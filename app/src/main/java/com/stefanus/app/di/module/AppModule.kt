package com.stefanus.app.di.module

import com.stefanus.app.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//class yang digunakan untuk pengaturan guna : Menyederhanakan pekerjaan basis data dan berfungsi
// sebagai titik akses ke basis data SQLite yang mendasarinya

@Module
class AppModule(private val app: App) {

  @Provides
  @Singleton
  internal fun providesApp(): App = app
}