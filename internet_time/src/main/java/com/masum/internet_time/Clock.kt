package com.masum.internet_time.listener

import android.app.Activity


import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Timer
import java.util.TimerTask

class Clock(private val callback: DateTimeChangeCallback, private val context: Activity) : TimeResponseCallbackListener {
    internal var mTimer: Timer? = null
    internal var mTimerTask: TimerTask? = null
    internal var second: Int = 0
    internal var minute: Int = 0
    internal var hour: Int = 0
    internal var time: String? = null

    companion object {
        const val SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS"
        const val SIMPLE_DATE_FORMAT = "dd/MM/yyyy"
        const val HOUR = "HH"
        const val MINUTE = "mm"
        const val SECOND = "ss"
        const val GMT_6 = "+06:00"
    }

    init {
        ApiResponse(this)
    }

    override fun apiDateResponse(dateTime: String) {
        val input = SimpleDateFormat(SERVER_DATE_FORMAT)
        val outputDate = SimpleDateFormat(SIMPLE_DATE_FORMAT)
        val outputH = SimpleDateFormat(HOUR)
        val outputM = SimpleDateFormat(MINUTE)
        val outputS = SimpleDateFormat(SECOND)
        val newString = dateTime.replace(GMT_6, "")
        var d: Date? = null
        try {
            d = input.parse(newString)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val date = outputDate.format(d!!)
        val h = outputH.format(d)
        val m = outputM.format(d)
        val s = outputS.format(d)
        time = "$hour:$minute:$second"
        second = Integer.parseInt(s)
        minute = Integer.parseInt(m)
        hour = Integer.parseInt(h)
        if (mTimer == null) {
            mTimer = Timer()
        }

        if (mTimer != null) {
            mTimerTask = object : TimerTask() {
                override fun run() {
                    second++
                    if (second > 59) {
                        second = 0
                        minute++
                        if (minute > 59) {
                            minute = 0
                            hour++
                            if (hour >= 24) {
                                hour = 0
                            }
                        }
                    }
                    time = "$hour:$minute:$second"

                    context.runOnUiThread {
                        callback.onDateTimeChange(date, time!!)
                    }
                }
            }
        }

        mTimer!!.scheduleAtFixedRate(mTimerTask, 0, 1000)
    }

    fun StopClock() {
        if (mTimer != null) {
            mTimer!!.cancel()
            mTimer = null
        }
        if (mTimerTask != null) {
            mTimerTask!!.cancel()
            mTimerTask = null
        }
    }
}
