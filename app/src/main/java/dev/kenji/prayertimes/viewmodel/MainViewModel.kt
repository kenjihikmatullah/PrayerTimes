package dev.kenji.prayertimes.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dev.kenji.prayertimes.database.PrayerTimesDatabase
import dev.kenji.prayertimes.repository.PrayerTimesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(val database: PrayerTimesDatabase) : ViewModel() {

    /**
     * Coroutine
     */
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)

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
            try {
                Log.i("MainViewModel", "Starting updatePrayerTimes()")
                repository.updatePrayerTimes()
                Log.i("MainViewModel", "Finishing updatePrayerTimes()")

            } catch (e: Exception) {
                Log.i("MainViewModel", e.message!!)
            }

        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}