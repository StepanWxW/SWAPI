package com.example.swapi.model

import java.time.LocalDateTime

data class Starship(
    val name: String,
    val model: String,
    val manufacturer: String,
    val cost_in_credits: Int,
    val length: Int,
    val max_atmosphering_speed: String,
    val crew: String,
    val passengers: String,
    val cargo_capacity: String,
    val consumables: String,
    val hyperdrive_rating: String,
    val MGLT: String,
    val starship_class: String,
    val pilots: List<String>,
    val films: List<String>,
    var created: LocalDateTime,
    var edited: LocalDateTime,
    var url: String
)