package com.example.swapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class Character(
    @JsonProperty("name") val name: String?,
    @JsonProperty("height") val height: String?,
    @JsonProperty("mass") val mass: String?,
    @JsonProperty("hair_color") val hairColor: String?,
    @JsonProperty("skin_color") val skinColor: String?,
    @JsonProperty("eye_color") val eyeColor: String?,
    @JsonProperty("birth_year") val birthYear: String?,
    @JsonProperty("gender") val gender: String?,
    @JsonProperty("homeworld") val homeWorld: String?,
    @JsonProperty("films") val films: List<String?>,
    @JsonProperty("species") val species: List<String?>,
    @JsonProperty("vehicles")val vehicles: List<String?>,
    @JsonProperty("starships")val starships: List<String?>,
    @JsonProperty("created")val created: String?,
    @JsonProperty("edited")val edited: String?,
    @JsonProperty("url")val url: String?
){

}

//data class Character(
//    val name: String,
//    val height: String,
//    val mass: String,
//    val hairColor: String,
//    val skinColor: String,
//    val eyeColor: String,
//    val birthYear: String,
//    val gender: String,
//    val homeWorld: String,
//    val films: List<String>,
//    var species: List<String>,
//    var vehicles: List<String>,
//    var starships: List<String>,
//    var created: LocalDateTime,
//    var edited: LocalDateTime,
//    var url: String
////    var isFavorite: Boolean = false
//)