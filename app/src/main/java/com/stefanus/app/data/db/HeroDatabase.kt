package com.stefanus.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.stefanus.app.data.db.converter.StringListConverter
import com.stefanus.app.data.db.dao.HeroDao
import com.stefanus.app.data.db.entity.HeroEntity

//sintak untuk menyimpan data ke file teks di perangkat
@Database(
    entities = [HeroEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    StringListConverter::class
)
abstract class HeroDatabase : RoomDatabase() {
  abstract fun heroDao(): HeroDao
}