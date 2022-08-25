package com.example.basic

import com.example.net.util.NetworkUtil
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * url追加参数
 */
class AppendUrlParamInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //1.获取到请求
        val request = chain.request()
        //2.得到之前的url
        val builder = request.url().newBuilder()
        //3.追加信息，得到新的url
        val newUrl = builder.addQueryParameter("deviceId", "123")
                .addQueryParameter("token", "456")
                .build()
        //4.新的url创建新的request
        val newRequest = request.newBuilder()
                .url(newUrl)
                .build()
        //5.返回
        return chain.proceed(newRequest)
    }

}


/**
 * 有网络的时候
 */
class OnlineInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val onlineCacheTime = 0 //在线的时候的缓存过期时间，如果想要不缓存，直接时间设置为0
        return response.newBuilder()
            .header("Cache-Control", "public, max-age=$onlineCacheTime")
            .removeHeader("Pragma")
            .build()
    }
}

/**
 * 没有网的时候
 */
class OfflineInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (!NetworkUtil.isNetworkAvailable()) {
            //从缓存取数据
            val newRequest = request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build()
            val maxTime = 60 * 60 * 24
            val response = chain.proceed(newRequest)
            return response.newBuilder()
                .removeHeader("Pragma")
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxTime")
                .build()
        }
        return chain.proceed(request)
    }
}





