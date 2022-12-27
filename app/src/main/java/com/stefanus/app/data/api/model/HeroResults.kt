package com.stefanus.app.data.api.model

import com.google.gson.annotations.SerializedName

//library ini berguna untuk menampilkan hasil konveksi dari JSON.
data class HeroResults(
  @SerializedName("response")
  val response: String? = null,
  @SerializedName("results")
  val results: List<Hero> = listOf(),
  @SerializedName("results-for")
  val resultsFor: String? = null
)