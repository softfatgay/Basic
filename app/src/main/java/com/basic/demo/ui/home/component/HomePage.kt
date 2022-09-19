package com.basic.demo.ui.home.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable

@Composable
fun HomePage() {
    LazyColumn(state = rememberLazyListState()){
        item {
            HomeSearch()
        }
    }
}