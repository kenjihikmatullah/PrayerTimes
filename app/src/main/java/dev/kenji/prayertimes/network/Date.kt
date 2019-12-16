package dev.kenji.prayertimes.network

import com.squareup.moshi.Json

data class Date(
    @Json(name = "readable")
    val readable: String,

    @Json(name = "timestamp")
    val timestamp: String,

    @Json(name = "hijri")
    val hijri: Hijri,

    @Json(name = "gregorian")
    val gregorian: Gregorian
)