package dev.kenji.prayertimes.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dev.kenji.prayertimes.database.PrayerTimesDatabase
import dev.kenji.prayertimes.repository.PrayerTimesRepository
import kotlinx.coroutines.*

class MainViewModel(val database: PrayerTimesDatabase) : ViewModel() {

    val scope = CoroutineScope(Dispatchers.Main)

    /**
     * Repository
     */
    private val repository = PrayerTimesRepository(database)
    var prayerTimes = repository.prayerTimes

    /**
     * Initialization
     */
    init {
        updatePrayerTimes()
    }

    private fun updatePrayerTimes() {
        scope.launch {
            repository.updatePrayerTimes()
        }
    }
}