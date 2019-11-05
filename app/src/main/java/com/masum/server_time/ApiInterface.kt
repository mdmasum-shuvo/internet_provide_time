package com.masum.server_time

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @get:GET("Asia/Dhaka")
    val serverTime: Call<ServerTimeResponse>
}
