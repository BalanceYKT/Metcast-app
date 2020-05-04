package com.example.recyclerview.model

data class Day(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val rain: Rain,
    val snow: Snow,
    val sys: Sys,
    val weather: List<Weather>,
    val wind: Wind
)