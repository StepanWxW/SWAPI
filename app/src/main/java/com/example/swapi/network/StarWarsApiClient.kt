package com.example.swapi.network
import com.example.swapi.db.ApiService
import com.example.swapi.db.modeldb.CharacterResponse
import com.example.swapi.db.modeldb.StarshipResponse
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class StarWarsApiClient {

    private val apiService: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    suspend fun searchCharacters(query: String): CharacterResponse {
        return apiService.searchCharacters(query)
    }

    suspend fun searchStarships(query: String): StarshipResponse {
        return apiService.searchStarships(query)
    }
}

