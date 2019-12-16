package dev.kenji.prayertimes.network

import com.squareup.moshi.Json

data class Weekday(
    @Json(name = "en")
    val en: String
//
//    @Json(name = "ar")
//    val ar: String
)