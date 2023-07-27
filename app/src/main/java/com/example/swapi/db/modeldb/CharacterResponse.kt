package com.example.swapi.db.modeldb

import com.example.swapi.model.Character

data class CharacterResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Character>
) {
    constructor() : this(0, null, null, emptyList())
}