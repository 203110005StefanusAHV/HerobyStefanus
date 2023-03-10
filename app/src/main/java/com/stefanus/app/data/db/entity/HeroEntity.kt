package com.stefanus.app.data.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.stefanus.app.data.db.converter.StringListConverter

//sintak membuat pemetaan tabel SQLite di database
@Entity(tableName = "stefanus")
data class HeroEntity(
  @PrimaryKey
  val id: String,
  val name: String? = null,
  val imageUrl: String? = null,
  @Embedded
  val biography: BiographyEntity? = null
)

data class BiographyEntity(
  @TypeConverters(StringListConverter::class)
  val aliases: ArrayList<String>? = null,
  val alignment: String? = null,
  val alterEgos: String? = null,
  val firstAppearance: String? = null,
  val fullName: String? = null,
  val placeOfBirth: String? = null,
  val publisher: String? = null
)
