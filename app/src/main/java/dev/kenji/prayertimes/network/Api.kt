package dev.kenji.prayertimes.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Base URL
 */
private const val BASE_URL = "https://api.aladhan.com/v1/"

/**
 * Moshi to convert json
 */
val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Retrofit to access network
 */
val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

/**
 * API services
 */
interface ApiServices {

    @GET("timingsByCity/:date_or_timestamp")
    suspend fun getCalendarByCity(
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: Int): Response
}

/**
 * API for whole app
 */
object Api {
    val apiServices: ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}