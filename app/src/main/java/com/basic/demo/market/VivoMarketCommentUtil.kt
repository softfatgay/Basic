package com.basic.demo.market

import android.app.Activity
import android.content.Intent
import android.net.Uri

object VivoMarketCommentUtil {

    private val PKG_MK_VIVO = "com.bbk.appstore" // Q之前的软件商店包名

    /**
     * 拉起评论页面。
     */
    fun jumpToComment(context: Activity) {
        try {
            val url = "market://details?id=${context.packageName}&th_name=${context.packageName}"

            val uri = Uri.parse(url)

            val intent = Intent(Intent.ACTION_VIEW, uri)

            intent.setPackage(PKG_MK_VIVO)

            context.startActivity(intent)
        } catch (_: Exception) {
        }
    }
}