package com.example.swapi.db

import com.example.swapi.db.modeldb.CharacterResponse
import com.example.swapi.db.modeldb.StarshipResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("people/")
    suspend fun searchCharacters(@Query("search") query: String): CharacterResponse

    @GET("starships/")
    suspend fun searchStarships(@Query("search") query: String): StarshipResponse

}