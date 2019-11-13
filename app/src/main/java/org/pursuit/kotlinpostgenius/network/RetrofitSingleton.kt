package org.pursuit.kotlinpostgenius.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {

    private const val BASE_URL: String = "https://reqres.in/api/"
    private var instance: Retrofit? = null

    fun getInstance(): Retrofit? {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        return instance
    }
}