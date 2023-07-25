
import com.example.swapi.model.ApiService
import com.example.swapi.model.CharacterResponse
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

//    suspend fun searchPlanets(query: String): PlanetResponse {
//        return apiService.searchPlanets(query)
//    }
}

