package com.incrowdsports.task.data

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val URL = "https://feeds.incrowdsports.com/provider/opta/football/v1/"

    private val client: OkHttpClient = OkHttpClient.Builder().build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(HttpUrl.get(URL))
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getFixtureService(): FixtureService {
        return retrofit.create(FixtureService::class.java)
    }

    fun getFixtureDetailsService(): FixtureDetailsService {
        return retrofit.create(FixtureDetailsService::class.java)
    }

}