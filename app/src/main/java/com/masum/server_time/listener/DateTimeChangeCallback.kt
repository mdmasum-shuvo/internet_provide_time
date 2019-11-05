package com.masum.server_time.listener

interface DateTimeChangeCallback {
    fun onDateTimeChange(date: String, time: String)
}
