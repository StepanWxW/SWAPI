package com.example.swapi.model

data class StarshipResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Starship>
){
    constructor() : this(0, null, null, emptyList())
}