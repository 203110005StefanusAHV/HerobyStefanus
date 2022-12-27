package com.stefanus.app.di.module

import androidx.room.Room
import com.stefanus.app.App
import com.stefanus.app.data.db.HeroDatabase
import com.stefanus.app.data.db.dao.HeroDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//class yang berisi modul untuk database.
@Module
class DatabaseModule constructor(private val app: App) {

  @Singleton
  @Provides
  fun providesHeroDatabase(): HeroDatabase =
    Room.databaseBuilder(app, HeroDatabase::class.java, "stefanus-db")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()

  @Provides
  @Singleton
  fun providesHeroDao(heroDatabase: HeroDatabase): HeroDao = heroDatabase.heroDao()
}