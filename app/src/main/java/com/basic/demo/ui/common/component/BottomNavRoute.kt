package com.basic.demo.ui.common.component

import android.graphics.drawable.Icon
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.basic.demo.R

sealed class BottomNavRoute(
    var routerName: String,
    @StringRes var stringId: Int,
    var icon: ImageVector
) {
    object Home :
        BottomNavRoute(routerName = RouteName.HOME, R.string.home_title, Icons.Default.Home)

    object Cart :
        BottomNavRoute(routerName = RouteName.CART, R.string.cart_title, Icons.Default.ShoppingCart)

    object Mine :
        BottomNavRoute(routerName = RouteName.MINE, R.string.mine_title, Icons.Default.Info)

}