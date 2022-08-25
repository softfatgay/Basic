//package com.example.net
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.net.util.ExceptionUtil
//import kotlinx.coroutines.CoroutineExceptionHandler
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.launch
//
//fun ViewModel.launch(
//    block: suspend CoroutineScope.() -> Unit,
//    onError: (e: Throwable) -> Unit = { _: Throwable -> },
//    onComplete: () -> Unit = {}
//) {
//    viewModelScope.launch(
//        CoroutineExceptionHandler { _, throwable ->
//            run {
//                // 这里统一处理错误
//                ExceptionUtil.catchException(throwable)
//                onError(throwable)
//            }
//        }
//    ) {
//        try {
//            block.invoke(this)
//        } finally {
//            onComplete()
//        }
//    }
//}