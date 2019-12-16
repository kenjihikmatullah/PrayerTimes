package dev.kenji.prayertimes.network

import com.squareup.moshi.Json;

data class Data(
    @Json(name = "timings")
    val timings: Timings,

    @Json(name = "date")
    val date: Date,

    @Json(name = "meta")
    val meta: Meta
)