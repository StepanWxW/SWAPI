package com.example.swapi.model

data class StarshipResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Starship>
)