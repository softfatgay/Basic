package com.basic.demo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import com.basic.demo.databinding.ActivityMainBinding
import com.basic.demo.home.HomeScreen
import com.basic.demo.viewModel.MainViewModel

enum class NaviType {
    HOME,CART,MINE
}


class MainActivity : ComponentActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    @SuppressLint("UnrememberedMutableState")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var navType = mutableStateOf(NaviType.HOME)
            Scaffold(
                bottomBar = {BottomNavBar(navType)},
            ) { paddingValues->
                Crossfade(targetState = navType,Modifier.padding(paddingValues)) {
                   when (it.value) {
                       NaviType.HOME -> HomeScreen()
                       NaviType.CART -> HomeScreen()
                       NaviType.MINE -> HomeScreen()
                   }
               }
            }
        }
    }

    @Composable
    private fun BottomNavBar(navType: MutableState<NaviType>) {
        BottomNavigation(backgroundColor = Color.White) {
            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = null) },
                selected = (navType.value == NaviType.HOME),
                onClick = { navType.value = NaviType.HOME  },
                label = { Text(text = "Home") },
            )

            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = null) },
                selected = navType.value == NaviType.CART,
                onClick = { navType.value = NaviType.CART },
                label = { Text(text = "Cart") },
            )

            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Outlined.Info, contentDescription = null) },
                selected = navType.value == NaviType.MINE,
                onClick = { navType.value = NaviType.MINE },
                label = { Text(text = "Mine") },
            )
        }
    }
}