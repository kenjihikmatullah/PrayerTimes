package dev.kenji.prayertimes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.kenji.prayertimes.database.PrayerTimesDatabase

class MainViewModelFactory(private val database: PrayerTimesDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(database) as T

        } else {
            throw IllegalArgumentException("Ada yang salah")
        }
    }
}