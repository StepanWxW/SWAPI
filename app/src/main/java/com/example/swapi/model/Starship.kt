package com.example.swapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Starship(
    @JsonProperty("name") val name: String?,
    @JsonProperty("model") val model: String?,
    @JsonProperty("manufacturer") val manufacturer: String?,
    @JsonProperty("cost_in_credits") val costInCredits: String? = null,
    @JsonProperty("length") val length: String? = null,
    @JsonProperty("max_atmosphering_speed") val maxAtmospheringSpeed: String? = null,
    @JsonProperty("crew") val crew: String? = null,
    @JsonProperty("passengers") val passengers: String?,
    @JsonProperty("cargo_capacity") val cargoCapacity: String? = null,
    @JsonProperty("consumables") val consumables: String? = null,
    @JsonProperty("hyperdrive_rating") val hyperdriveRating: String? = null,
    @JsonProperty("MGLT") val MGLT: String? = null,
    @JsonProperty("starship_class") val starshipClass: String? = null,
    @JsonProperty("pilots") val pilots: List<String?> = emptyList(),
    @JsonProperty("films") val films: List<String?> = emptyList(),
    @JsonProperty("created") val created: String? = null,
    @JsonProperty("edited") val edited: String? = null,
    @JsonProperty("url") val url: String? = null
) {
    constructor(name: String?, model: String?, manufacturer: String?, passengers: String?) : this(
        name = name,
        model = model,
        manufacturer = manufacturer,
        passengers = passengers,
        costInCredits = null,
        length = null,
        maxAtmospheringSpeed = null,
        crew = null,
        cargoCapacity = null,
        consumables = null,
        hyperdriveRating = null,
        MGLT = null,
        starshipClass = null,
        pilots = emptyList(),
        films = emptyList(),
        created = null,
        edited = null,
        url = null
    )
}