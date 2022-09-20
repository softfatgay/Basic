package com.basic.demo.ui.home.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.basic.demo.theme.AppTheme
import com.basic.demo.theme.themeColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    var text by remember {
        mutableStateOf("")//可观察的文本
    }
    Scaffold(
        topBar = {
            HomeSearch(input = text, onValueChange = {
                text = it
                Log.e("textFiled------->", text)
            })
        },
        content = {
            Content()
        }
    )
}

@Composable
private fun Content() {
    val lists by remember {
        mutableStateOf(listOf("a", "b", "c", "d"))
    }

    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 0.dp)
    ) {
        itemsIndexed(items = lists) { index, _ ->
            Text(
                text = "我是第${index}条目",
                modifier = Modifier
                    .background(themeColor)
                    .height(120.dp)
                    .fillMaxWidth()
            )
        }
    }
}