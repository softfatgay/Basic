package com.example.net.interceptor

import android.text.TextUtils
import com.example.net.Constants
import okhttp3.Interceptor
import okhttp3.Response

/**
 * 请求头鉴权
 */
class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //1.获取到请求
        val request = chain.request()
        //2.得到之前的url
        val builder = request.url().newBuilder()

        //3.追加信息，得到新的url---
        val newUrl = builder.build()
        //4.新的url创建新的request
        val newBuilder = request.newBuilder()
        val isNoToken = request.header(Constants.NO_TOKEN)

        if(!TextUtils.isEmpty(isNoToken)){
            newBuilder.removeHeader(Constants.TOKEN)
            newBuilder.removeHeader(Constants.NO_TOKEN)
        }

        val newRequest = newBuilder
                .url(newUrl)
                .build()

        //5.返回
        return chain.proceed(newRequest)
    }

}