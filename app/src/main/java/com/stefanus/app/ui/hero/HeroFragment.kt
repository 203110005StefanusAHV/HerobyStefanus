package com.stefanus.app.ui.hero

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.navigation.fragment.findNavController
import com.stefanus.app.BR
import com.stefanus.app.R
import com.stefanus.app.databinding.HeroFragmentBinding
import com.stefanus.app.di.component.AppComponent
import com.stefanus.app.ui.base.BaseFragment
import com.stefanus.app.ui.hero.data.HeroAdapter
import com.stefanus.app.ui.hero.data.HeroItemDecorator
import com.stefanus.app.util.json
import com.stefanus.app.util.onTextChange
import javax.inject.Inject

//berisi pengelolaan tata letak dan penataan mulai dari list hero dan input nama.
class HeroFragment : BaseFragment<HeroFragmentBinding, HeroViewModel>(R.layout.hero_fragment) {

  @Inject
  lateinit var heroAdapter: HeroAdapter

  override fun inject(appComponent: AppComponent) {
    appComponent.inject(this)
  }

  override fun getViewModel(factory: Factory): HeroViewModel = ViewModelProvider(this, factory).get(HeroViewModel::class.java)
  override fun getBindingVariable(): Int = BR.viewModel

  override fun setupUI() {
    dataBinding.listHeroes.addItemDecoration(HeroItemDecorator())
    dataBinding.listHeroes.adapter = heroAdapter
  }

  override fun setupListeners() {
    heroAdapter.callback = {
      findNavController().navigate(HeroFragmentDirections.actionHeroFragmentToHeroDetailsFragment(it.json()))
    }

    dataBinding.inputName.onTextChange {
      viewModel.inputTextPublisher.onNext(it)
    }

    dataBinding.btnClear.setOnClickListener {
      dataBinding.inputName.clearFocus()
      dataBinding.inputName.setText("")
      viewModel.clearSearches()
    }
  }
}