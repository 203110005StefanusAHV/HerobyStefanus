package com.stefanus.app

import android.app.Application
import com.stefanus.app.di.component.AppComponent
import com.stefanus.app.di.component.DaggerAppComponent
import com.stefanus.app.di.module.ApiModule
import com.stefanus.app.di.module.AppModule
import com.stefanus.app.di.module.DatabaseModule
import timber.log.Timber

//aktivitas menentukan apa yang dilakukan aplikasi dan bagaimana seharusnya menanggapi pengguna.
class App : Application() {

  override fun onCreate() {
    super.onCreate()
    setupLogging()
    setupDagger()
  }

  private fun setupLogging() {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }

  private fun setupDagger() {
    appComponent = DaggerAppComponent.builder()
        .databaseModule(DatabaseModule(this))
        .apiModule(ApiModule(this))
        .appModule(AppModule(this))
        .build()
    appComponent.inject(this)
  }

  companion object {
    lateinit var appComponent: AppComponent
  }
}