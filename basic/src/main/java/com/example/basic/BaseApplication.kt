package com.example.basic

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.basic.utils.Logu
import com.example.basic.utils.PackageUtil

open class BaseApplication : Application() {

    companion object {
        lateinit var instance: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        registActivityCallBack()
    }

    private fun registActivityCallBack() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
                val firstActivity = PackageUtil.isFirstActivity(activity)
                if (firstActivity) {
                    Logu.d(
                        "${Constants.LAUNCH_LOG}firstView",
                        "${System.currentTimeMillis()}"
                    )
                }
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }
        })
    }
}
