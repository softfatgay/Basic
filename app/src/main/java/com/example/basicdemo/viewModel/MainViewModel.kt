package com.example.basicdemo.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.basicdemo.net.RetrofitClint
import com.example.basicdemo.utils.JsonFormatUtil
import com.example.net.SingleLiveEvent
import com.example.net.viewmodel.BaseNetViewModel
import com.example.net.viewmodel.UIStatus

class MainViewModel : BaseNetViewModel() {
    val homeData = MutableLiveData<String>()
    fun testData() {
        showLoading()
        launch({
            val data = RetrofitClint.apiService.indexJson(System.currentTimeMillis() / 1000)
            val string = data.string()
            homeData.postValue(JsonFormatUtil.formatDataFromJson(string))
            RetrofitClint.apiService.searchRepos("java",1,10)

        }, onError = {
            Log.e("-------------------","]]]]]]]]]]]]]]]]]]]]]]")
            showRetry()
        }, onComplete = {
            showContent()
        })
    }
}