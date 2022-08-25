package com.example.basicdemo.net

import com.example.basicdemo.net.apiservice.ApiService
import com.example.net.RetrofitUtil

object RetrofitClint {
    val apiService by lazy {
        RetrofitUtil.baseUrl("https://m.you.163.com/").initService(ApiService::class.java)
    }
}