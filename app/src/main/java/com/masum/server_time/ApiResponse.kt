package com.masum.server_time

import com.masum.server_time.listener.TimeResponseCallbackListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiResponse(private val mListener: TimeResponseCallbackListener?) {

    init {
        data()
    }

    fun data() {

        TimeRestClient.apiInterface.serverTime.enqueue(object : Callback<ServerTimeResponse> {
            override fun onResponse(call: Call<ServerTimeResponse>, response: Response<ServerTimeResponse>) {
                if (response.isSuccessful) {
                    mListener?.apiDateResponse(response.body()!!.datetime)
                }
            }

            override fun onFailure(call: Call<ServerTimeResponse>, t: Throwable) {

            }
        })
    }


}
