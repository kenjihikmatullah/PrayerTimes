package dev.kenji.prayertimes.network

import com.squareup.moshi.Json

data class Params(
    @Json(name = "Fajr")
    val fajr: Int,

    @Json(name = "Isha")
    val isha: Int
)