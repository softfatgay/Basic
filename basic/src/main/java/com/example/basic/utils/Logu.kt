package com.example.basic.utils

import android.util.Log
import androidx.annotation.NonNull
import com.example.basic.BuildConfig

object Logu {
    fun e(@NonNull tag: String, @NonNull msg: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg)
        }
    }

    fun i(@NonNull tag: String, @NonNull msg: String) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, msg)
        }
    }

    fun d(@NonNull tag: String, @NonNull msg: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg)
        }
    }

}