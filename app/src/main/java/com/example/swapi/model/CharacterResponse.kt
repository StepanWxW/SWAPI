package com.example.swapi.model

data class CharacterResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Character>
) {
    // Пустой конструктор без аргументов
    constructor() : this(0, null, null, emptyList())
}