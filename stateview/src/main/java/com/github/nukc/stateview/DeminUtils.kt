package com.github.nukc.stateview

import android.content.Context

object DeminUtils {
    fun dp2px(context: Context, dp: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }
}