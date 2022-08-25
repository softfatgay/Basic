package com.example.basic

import android.app.Application

open class BaseApplication :Application() {

    companion object {
        lateinit var instance: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}