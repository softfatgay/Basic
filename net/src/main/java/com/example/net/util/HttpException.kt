package com.example.net.util

import android.accounts.NetworkErrorException
import android.util.Log
import android.util.MalformedJsonException
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.basic.BaseApplication
import com.example.net.R
import com.google.gson.JsonSyntaxException
import retrofit2.HttpException
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object HttpException {


    /**
     * 处理异常，toast提示错误信息
     */
    fun catchException(e: Throwable) {
        e.printStackTrace()
        when (e) {
            is HttpException -> {
                catchHttpException(e.code())
            }
            is SocketTimeoutException -> {
                showToast(R.string.net_time_out)
            }
            is UnknownHostException, is NetworkErrorException -> {
                showToast(R.string.common_error_net)
            }
            is MalformedJsonException, is JsonSyntaxException -> {
                showToast(R.string.error_server_json)
            }
            is InterruptedIOException -> {
                showToast(R.string.common_error_net)
            }
            // 自定义接口异常
//            is ApiException -> {
//                showToast(e.message?:"", e.code)
//            }
            is ConnectException -> {
                showToast( R.string.connect_server_error)
            }
            else -> {
                showToast("${BaseApplication.instance.getString(
                    R.string.common_error
                )}：${e::class.java.name}")
            }
        }
    }

    /**
     * 处理网络异常
     */
    fun catchHttpException(errorCode: Int) {
        if (errorCode in 200 until 300) return// 成功code则不处理
        showToast(
            catchHttpExceptionCode(
                errorCode
            ), errorCode
        )
    }

    /**
     * toast提示
     */
    private fun showToast(@StringRes errorMsg: Int, errorCode: Int = -1) {
        showToast(
            BaseApplication.instance.getString(
                errorMsg
            ), errorCode
        )
    }

    /**
     * toast提示
     */
    private fun showToast(errorMsg: String, errorCode: Int = -1) {
        Log.e("http-error=>errorCode:","$errorCode")
        Toast.makeText(BaseApplication.instance,errorMsg,Toast.LENGTH_LONG).show()
//        if (errorCode == -1) {
//            ToastUtils.showShort(errorMsg)
//        } else {
//            ToastUtils.showShort("$errorCode：$errorMsg")
//        }
    }

    /**
     * 处理网络异常
     */
    private fun catchHttpExceptionCode(errorCode: Int): Int = when (errorCode) {
        in 500..600 -> R.string.common_error_server
        in 400 until 500 -> R.string.common_error_request
        else -> R.string.common_error_request
    }
}