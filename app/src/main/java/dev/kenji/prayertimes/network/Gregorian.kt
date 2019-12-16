package dev.kenji.prayertimes.network

import com.squareup.moshi.Json

data class Gregorian (
    @Json(name = "date")
    val date: String,

    @Json(name = "format")
    val format: String,

    @Json(name = "day")
    val day: String,

    @Json(name = "weekday")
    val weekday: Weekday,

    @Json(name = "month")
    val month: Month,

    @Json(name = "year")
    val year: String,

    @Json(name = "designation")
    val designation: Designation
)