package com.example.net

import android.util.ArrayMap
import com.example.net.interceptor.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtil {
    //    https://m.you.163.com/xhr/index.json?__timestamp=1661395230483&
//    private const val BASE_URL = "https://api.github.com/"
//    private  var BASE_URL = "https://m.you.163.com/"
    private var BASE_URL = ""

    fun baseUrl(url: String): RetrofitUtil {
        BASE_URL = url
        return this
    }

    // 缓存大小
    private const val maxCacheSize = 1024 * 1024 * 10L

    // 创建OkHttp实例
    private var okHttpClient: OkHttpClient

    init {
        val client = OkHttpClient.Builder()

        // 去除header中不需要的参数
        client.addInterceptor(AuthInterceptor())

//        //参数
//        client.addInterceptor(AppendUrlParamInterceptor())
//
//        //缓存设置
//        val cacheFile = File(PathUtil.getDiskCachePath(), "cache_retrofit")
//        val cache = Cache(cacheFile, maxCacheSize)
//        client.cache(cache)
//            .addInterceptor(OfflineInterceptor())
//            .addNetworkInterceptor(OnlineInterceptor())
//
//
        // 在Debug模式下设置日志拦截器
        if (BuildConfig.DEBUG) {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            client.addInterceptor(logger)
        }
        okHttpClient = client.build()
    }

    private fun getRetrofit(): Retrofit {
        // 生成Retrofit实例
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val mApis = ArrayMap<String, Any>()

    // 对外提供的方法
    @Suppress("UNCHECKED_CAST")
    fun <T> provide(apiInterfaceClass: Class<T>): T {
        val api = mApis[apiInterfaceClass.name] as T ?: getRetrofit().create(apiInterfaceClass)
        mApis[apiInterfaceClass.name] = api
        return api
    }

    fun <T> initService(t: Class<T>): T {
        return getRetrofit().create(t)
    }
}
