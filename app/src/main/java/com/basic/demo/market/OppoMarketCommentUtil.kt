package com.basic.demo.market

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build

object OppoMarketCommentUtil {

    private val PKG_MK_HEYTAP = "com.heytap.market" // Q之后的软件商店包名

    private val PKG_MK_OPPO = "com.oppo.market" // Q之前的软件商店包名

    private val COMMENT_DEEPLINK_PREFIX = "oaps://mk/developer/comment?pkg="
    private val SUPPORT_MK_VERSION = 84000 // 支持评论功能的软件商店版本

    /**
     * 拉起评论页面。
     */
    fun jumpToComment(context: Activity): Boolean {
        // 此处一定要传入调用方自己的包名，不能给其他应用拉起评论页。
        val url = COMMENT_DEEPLINK_PREFIX + context.getPackageName()
        // 优先判断heytap包
        if (getVersionCode(context, PKG_MK_HEYTAP) >= SUPPORT_MK_VERSION) {
            return jumpApp(context, Uri.parse(url), PKG_MK_HEYTAP)
        }
        return if (getVersionCode(context, PKG_MK_OPPO) >= SUPPORT_MK_VERSION) {
            jumpApp(context, Uri.parse(url), PKG_MK_OPPO)
        } else false
    }

    /**
     * 获取目标app版本号~
     *
     * @param context
     * @param packageName
     * @return 返回版本号
     */
    private fun getVersionCode(context: Activity, packageName: String): Long {
        var versionCode: Long = -1
        try {
            val info: PackageInfo = context.getPackageManager()
                .getPackageInfo(packageName, PackageManager.GET_META_DATA)
            if (info != null) {
                versionCode =
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) info.longVersionCode else info.versionCode.toLong()
            }
        } catch (e: PackageManager.NameNotFoundException) {
        }
        return versionCode
    }

    private fun jumpApp(context: Activity, uri: Uri, targetPkgName: String): Boolean {
        try {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            intent.setPackage(targetPkgName)
            intent.data = uri
            // 建议采用startActivityForResult 方法启动商店页面，requestCode由调用方自定义且必须大于0，软件商店不关注
            context.startActivityForResult(intent, 100)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }
}