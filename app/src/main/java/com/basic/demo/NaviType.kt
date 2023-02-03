package com.basic.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.basic.demo.databinding.ActivityMainBinding
import com.basic.demo.theme.AppTheme
import com.basic.demo.ui.common.MainPage
import com.basic.demo.viewModel.MainViewModel

class MainActivity : ComponentActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(AppTheme.Theme.Light) {
                MainPage()
            }
        }
    }
}

enum class NaviType {
    HOME, CART, MINE
}
