package dev.kenji.prayertimes.network

import com.squareup.moshi.Json

data class Designation(
    @Json(name = "abbreviated")
    val abbreviated: String,

    @Json(name = "expanded")
    val expanded: String
)