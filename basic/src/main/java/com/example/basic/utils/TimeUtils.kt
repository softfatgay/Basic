package com.example.basic.utils

import java.text.SimpleDateFormat

object TimeUtils {
    fun getDateTime(s: Long): String {
        return SimpleDateFormat("yyyy-MM-DD-hh-mm-ss").format(s)
    }
}