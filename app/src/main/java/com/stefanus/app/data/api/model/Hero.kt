package com.stefanus.app.data.api.model

import com.google.gson.annotations.SerializedName

//Gson adalah library untuk mengonversi objek Java ke dan dari JSON menggunakan refleksi.
// Kita bisa menentukan objek Java yang memiliki nama yang sama dengan kunci JSON yang sesuai,
// meneruskan objek kelas pada GSON, dan Gson akan mengisi kolomnya.
data class Hero(
  @SerializedName("id")
  val id: String,
  @SerializedName("name")
  val name: String? = null,
  @SerializedName("image")
  val image: Image? = null,
  @SerializedName("biography")
  val biography: Biography? = null,
)

data class Image(
  @SerializedName("url")
  val url: String? = null
)

data class Biography(
  @SerializedName("aliases")
  val aliases: List<String>? = null,
  @SerializedName("alignment")
  val alignment: String? = null,
  @SerializedName("alter-egos")
  val alterEgos: String? = null,
  @SerializedName("first-appearance")
  val firstAppearance: String? = null,
  @SerializedName("full-name")
  val fullName: String? = null,
  @SerializedName("place-of-birth")
  val placeOfBirth: String? = null,
  @SerializedName("publisher")
  val publisher: String? = null
)
