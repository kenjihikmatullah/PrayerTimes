package dev.kenji.prayertimes.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class PrayerTimes (
    @PrimaryKey(true)
    val id: Int = 0,
    var shubuh: String = "",
    var sunrise: String = "",
    var dhuhur: String = "",
    var ashar: String = "",
    var maghrib: String = "",
    var isya: String = ""
)