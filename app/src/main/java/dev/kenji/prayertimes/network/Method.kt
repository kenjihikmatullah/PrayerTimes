package dev.kenji.prayertimes.network

import com.squareup.moshi.Json

data class Method (
    @Json(name = "id")
    var id: Int,

    @Json(name = "name")
    var name: String,

    @Json(name = "params")
    var params: Params
)