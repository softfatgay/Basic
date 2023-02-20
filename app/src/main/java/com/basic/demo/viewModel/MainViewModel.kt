package com.basic.demo.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.basic.demo.net.RetrofitClint
import com.basic.demo.utils.JsonFormatUtil
import com.example.net.viewmodel.BaseNetViewModel

class MainViewModel : BaseNetViewModel() {
    val homeData = MutableLiveData<String>()
    fun testData() {
        showLoading()
        launch({
            val data = RetrofitClint.apiService.indexJson(System.currentTimeMillis() / 1000)
            val string = data.string()
            homeData.postValue(JsonFormatUtil.formatDataFromJson(string))
            RetrofitClint.apiService.searchRepos("java", 1, 10)
        }, onError = {
                Log.e("-------------------", "]]]]]]]]]]]]]]]]]]]]]]")
                showRetry()
            }, onComplete = {
                showContent()
            })
    }
}