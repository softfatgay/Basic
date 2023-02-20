package com.basic.demo.ui.home.component

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    var text by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            HomeSearch(
                input = text,
                onValueChange = {
                    text = it
                    Log.e("textFiled------->", text)
                }
            )
        },
        content = {
            Content()
        }
    )
}

@Composable
fun AnimatedVisibilityTest() {
    var isShow by remember {
        mutableStateOf(true)
    }
    Column() {
        AnimatedVisibility(visible = isShow) {
            Text(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 40.dp)
                    .background(Color.Red)
                    .clickable {
                        isShow = !isShow
                    },
                text = if (isShow) "显示" else "隐藏"
            )
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = { isShow = !isShow }) {
            Text(text = "click")
        }
    }
}

@SuppressLint("UnusedCrossfadeTargetStateParameter")
@Composable
fun CrossfadeTest() {
    var isShow by remember {
        mutableStateOf(true)
    }
    Column() {
        Crossfade(
            targetState = isShow,
            animationSpec = spring()
        ) {
            if (isShow) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .background(Color.Blue)
                        .clickable {
                            isShow = !isShow
                        },
                    text = if (isShow) "显示" else "隐藏"
                )
            } else {
                Text(
                    modifier = Modifier
                        .padding(vertical = 200.dp)
                        .background(Color.Red),
                    text = if (isShow) "显示" else "隐藏"
                )
            }
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = { isShow = !isShow }) {
            Text(text = "click")
        }
    }
}

@Composable
private fun Content() {
    val current = LocalContext.current
    val lists by remember {
        mutableStateOf(
            listOf(
                "a",
                "b",
                "c",
                "d",
                "b",
                "c",
                "d",
                "b",
                "c",
                "d",
                "b",
                "c",
                "d",
                "b",
                "c",
                "d",
                "b",
                "c",
                "d",
                "b",
                "c",
                "d"
            )
        )
    }
    var count by remember {
        mutableStateOf(1)
    }
    val color = animateColorAsState(if (count > 2) Color.Green else Color.Red)
    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier.offset(y = 100.dp)
    ) {
        itemsIndexed(items = lists) { index, _ ->
            count++
            ClickableText(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .background(Color.Red),
                text = AnnotatedString("我是第${index}条"),
                onClick = {
                    Toast.makeText(current, "我是第${index}条", Toast.LENGTH_LONG).show()
                }
            )
        }
    }
}