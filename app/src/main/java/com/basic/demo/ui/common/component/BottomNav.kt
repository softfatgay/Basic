package com.basic.demo.ui.common.component

import androidx.compose.ui.graphics.vector.ImageVector
import com.basic.demo.R
import com.basic.demo.ui.common.RouteName

sealed class BottomNav(val routerName: String, val resId: Int, val icon: ImageVector) {
    object Home : BottomNav(routerName = RouteName.HOME, R.string.confirm_tv)
}