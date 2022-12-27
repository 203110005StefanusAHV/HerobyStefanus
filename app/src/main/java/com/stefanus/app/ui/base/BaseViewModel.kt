package com.stefanus.app.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

//berisi data yang diperlukan dalam Tampilan dan menerjemahkan data yang disimpan dalam Model
// yang kemudian dapat ditampilkan di dalam Tampilan. ViewModel dan View terhubung
// melalui Databinding dan Livedata yang dapat diamati.

abstract class BaseViewModel : ViewModel() {

  private var compositeDisposable = CompositeDisposable()

  fun addSubscription(disposable: Disposable) {
    compositeDisposable.add(disposable)
  }

  override fun onCleared() {
    compositeDisposable.clear()
    super.onCleared()
  }
}