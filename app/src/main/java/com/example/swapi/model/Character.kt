package com.example.swapi.model

data class Character(
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val homeWorld: String,
    val films: List<String>,
    var isFavorite: Boolean = false // По умолчанию персонаж не является избранным
)