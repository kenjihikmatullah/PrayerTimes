package dev.kenji.prayertimes.network

import com.squareup.moshi.Json

data class Meta (
    @Json(name = "latitude")
    val latitude: Double,

    @Json(name = "longitude")
    val longitude: Double,

    @Json(name = "timezone")
    val timezone: String,

    @Json(name = "method")
    val method: Method,

    @Json(name = "latitudeAdjustmentMethod")
    val latitudeAdjustmentMethod: String,

    @Json(name = "midnightMode")
    val midnightMode: String,

    @Json(name = "school")
    val school: String,

    @Json(name = "offset")
    val offset: Offset
)