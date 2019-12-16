package dev.kenji.prayertimes.repository

import android.util.Log
import dev.kenji.prayertimes.database.PrayerTimesDatabase
import dev.kenji.prayertimes.network.Api
import dev.kenji.prayertimes.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PrayerTimesRepository (private val database: PrayerTimesDatabase) {

    private var city = "Surabaya"
    private var country = "Indonesia"
    private var method = 3

    val prayerTimes = database.prayerTimesDao.get()

    suspend fun updatePrayerTimes() {
        withContext(Dispatchers.IO) {
            /**
             * Get timings from network
             */
            Log.i("PrayerTimesRepository", "Ready to fetch data from network")
            val timings = Api.apiServices.getCalendarByCity(city, country, method).await().data.timings
            Log.i("PrayerTimesRepository", "Data fetched from network")

            /**
             * Insert it to database
             */
            database.prayerTimesDao.insert(timings.asDatabaseModel())
        }
    }
}