package com.example.basicdemo.utils

import org.json.JSONObject
import org.json.JSONArray
import java.lang.Exception

object JsonFormatUtil {
    /**
     * json 数据格式化输出
     */
    fun formatDataFromJson(response: String): String {
        try {
            if (response.startsWith("{")) {
                val jsonObject = JSONObject(response)
                return jsonObject.toString(4)
            } else if (response.startsWith("[")) {
                val jsonArray = JSONArray(response)
                return jsonArray.toString(4)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return response
    }
}