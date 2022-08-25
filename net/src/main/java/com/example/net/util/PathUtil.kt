package com.example.net.util

import android.os.Environment
import com.example.basic.BaseApplication

object PathUtil {
    /**
     * 获取cache路径
     */
    fun getDiskCachePath(): String {
        return if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState() || !Environment.isExternalStorageRemovable()) {
            BaseApplication.instance.externalCacheDir!!.path
        } else {
            BaseApplication.instance.cacheDir.path
        }
    }
}