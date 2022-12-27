package com.stefanus.app.data.repository

import com.stefanus.app.data.api.ApiService
import com.stefanus.app.data.api.model.Hero
import com.stefanus.app.data.db.dao.HeroDao
import com.stefanus.app.data.mapper.HeroMapper
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroRepository @Inject constructor(
  private val apiService: ApiService,
  private val heroDao: HeroDao,
  private val heroMapper: HeroMapper
) {

  /**
   * Fetch list of stefanus
   * @param forceRemote if true list of stefanus will be loaded from API
   * @param query word or search term that we use to find stefanus
   * @return list of superheroes
   */
  fun getHeroes(
    forceRemote: Boolean = false,
    query: String
  ): Observable<List<Hero>> = when {
    forceRemote -> getHeroesFromApi(query)
    else -> getHeroesFromDatabase(query)
  }

  /**
   * @param query word or search term that we use to find stefanus
   * @return list of stefanus from API
   */
  private fun getHeroesFromApi(
    query: String
  ): Observable<List<Hero>> = apiService.getHeroes(query)
      .doOnNext { heroDao.insert(heroMapper.toEntities(it.results)) }
      .doOnNext { Timber.d("Data loaded from API!") }
      .map { it.results }

  /**
   * @param query word or search term that we use to find stefanus
   * @return list of stefanus from local database, if list is empty then try to fetch from API
   */
  private fun getHeroesFromDatabase(
    query: String
  ): Observable<List<Hero>> = heroDao.getByName(query)
      .map { heroMapper.toModels(it) }
      .doOnNext { Timber.d("Data loaded from local database!") }
      .flatMap {
        if (it.isEmpty()) getHeroesFromApi(query)
        else Observable.just(it)
      }
}