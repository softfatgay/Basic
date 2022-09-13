package com.basic.demo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class BaseModel<T>(
    val data: T,
    val code: String
)
