package com.example.basic.utils

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import com.example.basic.BaseApplication

object PackageUtil {
    fun isFirstActivity(activity: Activity): Boolean {
        val packageManager = BaseApplication.instance.packageManager
        val packageName = getPackageName()
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        val component = intent?.component
        val componentName = activity.componentName
        if (component.toString() == componentName.toString())
            return true
        return false
    }

    fun getPackageName(): String {
        return BaseApplication.instance.packageName
    }
}