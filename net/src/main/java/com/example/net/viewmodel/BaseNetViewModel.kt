package com.example.net.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.net.util.HttpException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

open class BaseNetViewModel : ViewModel() {

    var UIState = SingleEvent<UIStatus>()

    init {
        UIState.value = UIStatus.NULL
    }

    fun showContent() {
        UIState.postValue(UIStatus.CONTENT)
    }

    fun showLoading() {
        UIState.postValue(UIStatus.LOADING)
    }

    fun showError() {
        UIState.postValue(UIStatus.ERROR)
    }

    fun showRetry() {
        UIState.postValue(UIStatus.RETRY)
    }

    fun launch(
        block: suspend CoroutineScope.() -> Unit,
        onError: (e: Throwable) -> Unit = { _: Throwable -> },
        onComplete: () -> Unit = {}
    ) {
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                run {
                    // 统一处理错误
                    HttpException.catchException(throwable)
                    onError(throwable)
                }
            }
        ) {
            try {
                block.invoke(this)
            } finally {
                onComplete()
            }
        }
    }

}