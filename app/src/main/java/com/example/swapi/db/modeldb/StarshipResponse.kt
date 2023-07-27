package com.example.swapi.db.modeldb

import com.example.swapi.model.Starship

data class StarshipResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Starship>
){
    constructor() : this(0, null, null, emptyList())
}