package com.example.basicdemo.net.apiservice

import com.example.basicdemo.model.BaseModel
import com.example.basicdemo.model.HomeDataModel
import com.example.basicdemo.model.SearchResultEntry
import com.example.net.Constants
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

//    xhr/index.json?__timestamp=1661395230483&

    @GET("search/repositories")
    @Headers("${Constants.TOKEN}: aaaaa", "${Constants.NO_TOKEN}: true")
    suspend fun searchRepos(
        @Query(value = "q", encoded = true) query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): SearchResultEntry


    @GET("xhr/index.json")
    suspend fun indexJson(
        @Query("__timestamp") page: Long,
    ): ResponseBody



}

