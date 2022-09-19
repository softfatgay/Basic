package com.basic.demo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.basic.demo.databinding.ActivityMainBinding
import com.basic.demo.home.HomeScreen
import com.basic.demo.theme.AppTheme
import com.basic.demo.ui.common.RouteName
import com.basic.demo.viewModel.MainViewModel
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.currentBackStackEntryAsState

enum class NaviType {
    HOME, CART, MINE
}


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
                AppScaffold()
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppScaffold(){
        val navCtrl = rememberNavController()
        val navBackStackEntry by navCtrl.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val scaffoldState = rememberScaffoldState()

        Scaffold(
            bottomBar = {
                when (currentDestination?.route) {
                    RouteName.HOME -> BottomNavBarView(navCtrl = navCtrl)
                }
            },
            content = {
                NavHost(
                    modifier = Modifier.background(MaterialTheme.colors.background),
                    navController = navCtrl,
                    startDestination = RouteName.HOME
                )
            }
        )
    }

    @Composable
    private fun BottomNavBar(navType: MutableState<NaviType>) {
        BottomNavigation(backgroundColor = Color.White) {
            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = null) },
                selected = (navType.value == NaviType.HOME),
                onClick = { navType.value = NaviType.HOME },
                label = { Text(text = "Home") },
            )

            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription = null
                    )
                },
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