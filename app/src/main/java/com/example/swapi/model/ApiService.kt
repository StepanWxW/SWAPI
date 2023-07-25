package com.example.swapi.model

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("people/")
    suspend fun searchCharacters(@Query("search") query: String): CharacterResponse

    @GET("starships/")
    suspend fun searchStarships(@Query("search") query: String): CharacterResponse
//    @GET("planets/")
//    suspend fun searchPlanets(@Query("search") query: String): PlanetResponse
}