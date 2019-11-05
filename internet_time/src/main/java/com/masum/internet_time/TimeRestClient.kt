package com.masum.internet_time.listener

import android.util.Log
import com.masum.internet_time.BuildConfig

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

import okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE


object TimeRestClient {

    private var retrofit: Retrofit? = null

    val apiInterface: ApiInterface
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl("http://worldtimeapi.org/api/timezone/")
                        .client(provideOkHttpClient())
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit!!.create(ApiInterface::class.java)
        }

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(provideHttpLoggingInterceptor())
                .build()
    }

    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.d("loggg", message) })
        httpLoggingInterceptor.level = if (BuildConfig.DEBUG) HEADERS else NONE
        return httpLoggingInterceptor
    }
}
