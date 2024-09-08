package com.advocatepedia.lite.data.network.day

import com.advocatepedia.lite.data.network.ApiCommons
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * WikiMedia API. Used to get the "today" data.
 */

/**
 * Base URL for the Wikimedia API
 */
private const val WikiMediaBaseUrl: String = "https://advocatepedia.com/"



/**
 * HTTP client
 */
private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(ApiCommons.loggingInterceptor)
    .build()

/**
 * Retrofit client, for creating the API service
 */
private val retrofit = Retrofit.Builder()
    .baseUrl(WikiMediaBaseUrl)
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create(ApiCommons.moshi))
    .build()

/**
 * Interface for Retrofit to handle queries
 */
interface WikiMediaApiService {
    @GET(
        "/feed/point.php"
    )
    /**
     * Fetches the "today" response for a certain date
     * @param yyyy The year
     * @param mm The month
     * @param dd The day
     */
    suspend fun getFeatured(
    ): NetworkDayResponse
}


object WikiMediaApiImpl {
    /**
     * Service for the WikiMedia API
     */
    val wikiMediaApiService: WikiMediaApiService by lazy {
        retrofit.create(WikiMediaApiService::class.java)
    }
}