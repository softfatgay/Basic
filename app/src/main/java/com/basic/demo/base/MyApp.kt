package com.basic.demo.base

import android.util.Log
import com.example.basic.BaseApplication
import com.example.basic.Constants
import com.example.basic.utils.Logu

class MyApp : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        Logu.d("${Constants.LAUNCH_LOG}app.onCreate", "${System.currentTimeMillis()}")

    }

}