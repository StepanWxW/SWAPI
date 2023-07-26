package com.example.swapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Character(
    @JsonProperty("name") val name: String?,
    @JsonProperty("height") val height: String? = null,
    @JsonProperty("mass") val mass: String? = null,
    @JsonProperty("hair_color") val hairColor: String? = null,
    @JsonProperty("skin_color") val skinColor: String? = null,
    @JsonProperty("eye_color") val eyeColor: String? = null,
    @JsonProperty("birth_year") val birthYear: String? = null,
    @JsonProperty("gender") val gender: String? = null,
    @JsonProperty("homeworld") val homeWorld: String? = null,
    @JsonProperty("films") val films: List<String?> = emptyList(),
    @JsonProperty("species") val species: List<String?> = emptyList(),
    @JsonProperty("vehicles") val vehicles: List<String?> = emptyList(),
    @JsonProperty("starships") val starships: List<String?> = emptyList(),
    @JsonProperty("created") val created: String? = null,
    @JsonProperty("edited") val edited: String? = null,
    @JsonProperty("url") val url: String? = null,
) {
    // Второй конструктор, использующий именованные параметры
    constructor(name: String?, gender: String?, countShip: Int) : this(
        name = name,
        gender = gender,
    ) {
        this.countShip = countShip
    }

    var countShip: Int? = null
}