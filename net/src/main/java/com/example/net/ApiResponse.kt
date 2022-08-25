package com.example.net

import android.util.Log
import com.google.gson.JsonParseException
import org.json.JSONException
import java.io.InterruptedIOException
import java.io.Serializable
import java.net.ConnectException
import java.net.UnknownHostException
import java.text.ParseException

data class ApiResponse<T>(
    val code: String,
    val msg: String,
    val data: T?
) : Serializable {
    fun isOK(): Boolean {
        return "200" == code
    }
}

object ApiResult {
    inline fun <T> create(request: () -> ApiResponse<T>): T? {
        return try {
            val response = request.invoke()
            response.data
        } catch (e: Exception) {
            if (e is ConnectException) {
//                ToastUtils.showShort("连接服务器失败")
            } else if (e is UnknownHostException) {
//                ToastUtils.showShort("未知服务器异常")
            } else if (e is InterruptedIOException) {
//                ToastUtils.showShort("连接服务器超时")
            } else if (e is JSONException || e is JsonParseException || e is ParseException) {
//                ToastUtils.showShort("数据解析出错")
            } else {
//                ToastUtils.showShort("未知的网络错误")
            }
            Log.e("ApiResult", "create: " + e.message)
            null
        }
    }
}

