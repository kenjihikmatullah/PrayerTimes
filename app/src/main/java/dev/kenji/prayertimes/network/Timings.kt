package dev.kenji.prayertimes.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.kenji.prayertimes.database.PrayerTimes

@JsonClass(generateAdapter = true)
data class Timings(
    @Json(name = "Fajr")
    val shubuh: String,

    @Json(name = "Sunrise")
    val sunrise: String,

    @Json(name = "Dhuhr")
    val dhuhur: String,

    @Json(name = "Asr")
    val ashar: String,

    @Json(name = "Sunset")
    val sunset: String,

    @Json(name = "Maghrib")
    val maghrib: String,

    @Json(name = "Isha")
    val isya: String,

    @Json(name = "Imsak")
    val imsak: String,

    @Json(name = "Midnight")
    val midnight: String )

fun Timings.asDatabaseModel(): PrayerTimes {
    return PrayerTimes(
        shubuh = shubuh,
        sunrise = sunrise,
        dhuhur = dhuhur,
        ashar = ashar,
        maghrib = maghrib,
        isya = isya
    )
}

