package com.stefanus.app.ui.hero

import androidx.databinding.ObservableField
import com.stefanus.app.data.api.model.Hero
import com.stefanus.app.data.repository.HeroRepository
import com.stefanus.app.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject

//data yang disimpan menggunakan pustaka ini tetap ada dalam perubahan di UI
// selama aktivitas/fragmen host-nya aktif.
class HeroViewModel @Inject constructor(
  private val heroRepository: HeroRepository
) : BaseViewModel() {

  val inputTextPublisher = PublishSubject.create<String>()

  val showLoading = ObservableField<Boolean>()
  val showWelcomeMessage = ObservableField(true)
  val showNoDataMessage = ObservableField<Boolean>()
  val heroes = ObservableField<List<Hero>>()

  init {
    val disposable = inputTextPublisher.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .debounce(500, MILLISECONDS)
        .distinctUntilChanged()
        .filter { it.isNotBlank() }
        .subscribe({ getHeroes(it) }, { handleError(it) })
    addSubscription(disposable)
  }

  private fun getHeroes(query: String) {
    val disposable = heroRepository.getHeroes(query = query, forceRemote = true)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe { showLoading() }
        .subscribe({ handleResponse(it) }, { handleError(it) })
    addSubscription(disposable)
  }

  private fun showLoading() {
    showWelcomeMessage.set(false)
    showNoDataMessage.set(false)
    showLoading.set(true)
  }

  private fun handleResponse(results: List<Hero>) {
    showLoading.set(false)
    showWelcomeMessage.set(false)
    showNoDataMessage.set(results.isNullOrEmpty())
    heroes.set(results)
  }

  private fun handleError(error: Throwable) {
    error.printStackTrace()
    showLoading.set(false)
    showNoDataMessage.set(true)
  }

  fun clearSearches() {
    heroes.set(listOf())
    showLoading.set(false)
    showNoDataMessage.set(false)
    showWelcomeMessage.set(true)
  }
}