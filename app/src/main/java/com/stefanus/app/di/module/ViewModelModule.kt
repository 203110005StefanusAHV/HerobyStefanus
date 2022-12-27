package com.stefanus.app.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stefanus.app.di.ViewModelProviderFactory
import com.stefanus.app.di.key.ViewModelKey
import com.stefanus.app.ui.hero.HeroViewModel
import com.stefanus.app.ui.hero_details.HeroDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//class modul untuk viewmodel.
@Module
abstract class ViewModelModule {

  @Binds
  abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory

  @Binds
  @IntoMap
  @ViewModelKey(HeroViewModel::class)
  abstract fun bindsHeroViewModel(viewModel: HeroViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(HeroDetailsViewModel::class)
  abstract fun bindsHeroDetailsViewModel(viewModel: HeroDetailsViewModel): ViewModel
}