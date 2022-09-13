package com.basic.demo.net

import com.basic.demo.net.apiservice.ApiService
import com.example.net.RetrofitUtil

object RetrofitClint {
    val apiService by lazy {
        RetrofitUtil.baseUrl("https://m.you.163.com/").initService(ApiService::class.java)
    }
}