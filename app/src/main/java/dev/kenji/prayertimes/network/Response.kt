package dev.kenji.prayertimes.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
    @Json(name = "code")
    val code: Int,

    @Json(name = "status")
    val status: String,

    @Json(name = "data")
    val data: Data
)