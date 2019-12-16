package dev.kenji.prayertimes.network

import com.squareup.moshi.Json

data class Month (
    @Json(name = "number")
    val number: Int,

    @Json(name = "en")
    val en: String
//
//    @Json(name = "ar")
//    val ar: String
)