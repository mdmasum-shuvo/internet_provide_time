package com.masum.server_time

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.masum.internet_time.listener.Clock
import com.masum.internet_time.listener.DateTimeChangeCallback

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DateTimeChangeCallback {

    internal lateinit var clock: Clock
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clock = Clock(this, this)


    }

    override fun onDateTimeChange(date: String, time: String) {
        tv_date_time.text = "$date  $time"
    }

    override fun onDestroy() {
        clock.StopClock()
        super.onDestroy()
    }


}
