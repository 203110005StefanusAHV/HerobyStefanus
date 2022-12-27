package com.stefanus.app.di.component

import com.stefanus.app.App
import com.stefanus.app.di.module.ApiModule
import com.stefanus.app.di.module.AppModule
import com.stefanus.app.di.module.DatabaseModule
import com.stefanus.app.di.module.ViewModelModule
import com.stefanus.app.ui.hero.HeroFragment
import com.stefanus.app.ui.hero_details.HeroDetailsFragment
import dagger.Component
import javax.inject.Singleton

//pengelompokan objek yang memeiliki ketergantungan terhadap objek lain.
@Singleton
@Component(
    modules = [
      DatabaseModule::class,
      ApiModule::class,
      AppModule::class,
      ViewModelModule::class]
)
interface AppComponent {
  fun inject(app: App)
  fun inject(heroFragment: HeroFragment)
  fun inject(heroDetailsFragment: HeroDetailsFragment)
}