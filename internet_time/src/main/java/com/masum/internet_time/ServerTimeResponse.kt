package com.masum.internet_time.listener

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ServerTimeResponse {

    @SerializedName("week_number")
    @Expose
    var weekNumber: Int? = null
    @SerializedName("utc_offset")
    @Expose
    var utcOffset: String? = null
    @SerializedName("utc_datetime")
    @Expose
    var utcDatetime: String? = null
    @SerializedName("unixtime")
    @Expose
    var unixtime: Int? = null
    @SerializedName("timezone")
    @Expose
    var timezone: String? = null
    @SerializedName("raw_offset")
    @Expose
    var rawOffset: Int? = null
    @SerializedName("dst_until")
    @Expose
    var dstUntil: Any? = null
    @SerializedName("dst_offset")
    @Expose
    var dstOffset: Int? = null
    @SerializedName("dst_from")
    @Expose
    var dstFrom: Any? = null
    @SerializedName("dst")
    @Expose
    var dst: Boolean? = null
    @SerializedName("day_of_year")
    @Expose
    var dayOfYear: Int? = null
    @SerializedName("day_of_week")
    @Expose
    var dayOfWeek: Int? = null
    @SerializedName("datetime")
    @Expose
    var datetime: String? = null
    @SerializedName("client_ip")
    @Expose
    var clientIp: String? = null
    @SerializedName("abbreviation")
    @Expose
    var abbreviation: String? = null

}