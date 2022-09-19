package com.basic.demo.ui.home.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key


@Composable
fun HomeSearch(input: String = "", onSearchInputChanged: (String) -> Unit) {
    OutlinedTextField(value = input,
        onValueChange = onSearchInputChanged,
        placeholder = {
            Text(text = "")
        },
        modifier = Modifier
            .fillMaxWidth(),
        singleLine = true,

    )

}