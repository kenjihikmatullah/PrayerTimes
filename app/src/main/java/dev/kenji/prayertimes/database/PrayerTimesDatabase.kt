package dev.kenji.prayertimes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database
 */
@Database(entities = [PrayerTimes::class], version = 1, exportSchema = false)
abstract class PrayerTimesDatabase : RoomDatabase() {
    abstract val prayerTimesDao: PrayerTimesDao
}

/** 
 * Database instance
 */
private lateinit var instance: PrayerTimesDatabase

/**
 * Get database instance
 */
fun getDatabase(context: Context): PrayerTimesDatabase {
    synchronized(PrayerTimesDatabase::class.java) {
        if (!::instance.isInitialized) {
            instance = Room.databaseBuilder(
                context.applicationContext,
                PrayerTimesDatabase::class.java,
                "prayer_times_database"
            ).build()
        }
        return instance
    }
}