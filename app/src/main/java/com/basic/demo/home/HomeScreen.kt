package com.basic.demo.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*


@Composable
fun HomeScreen() {

    var aa by remember { mutableStateOf(1) }

    Column {
        Button(onClick = {
            aa++
        }) {
            Text(text = "$aa")
        }
    }
}