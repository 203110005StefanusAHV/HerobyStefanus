package com.stefanus.app.data.api

import com.stefanus.app.data.api.model.HeroResults
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

//class ini digunakan untuk untuk mengintegrasikan dua bagian dari aplikasi
//atau dengan aplikasi yang berbeda secara bersamaan.
//class api ini digunakan untuk mengintegrasikan pada class search

interface ApiService {

  @GET("search/{query}")
  fun getHeroes(@Path(value = "query", encoded = true) name: String): Observable<HeroResults>
}