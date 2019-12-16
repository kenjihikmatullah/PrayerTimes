package dev.kenji.prayertimes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PrayerTimesDao {
    @Insert
    fun insert(prayerTimes: PrayerTimes)

    @Query("SELECT * FROM PrayerTimes ORDER BY id DESC LIMIT 1")
    fun get(): LiveData<PrayerTimes>

    @Query("DELETE FROM PrayerTimes")
    fun clear()
}