package com.basic.demo.base

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.basic.demo.R
import com.github.nukc.stateview.StateView
import com.tbruyelle.rxpermissions3.Permission
import com.tbruyelle.rxpermissions3.RxPermissions

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mStateView: StateView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        mStateView = StateView.inject(this)
        mStateView.onRetryClickListener = object : StateView.OnRetryClickListener {
            override fun onRetryClick() {
                mStateView.showContent()
                reTry()
            }
        }
        initView(savedInstanceState)
        initView()
        initData()
        initEvent()
    }

    open fun initView() {}
    open fun initData() {}
    open fun initEvent() {}
    open fun reTry() {}

    protected abstract val layout: View

    open fun initView(savedInstanceState: Bundle?) {}


    var mPermissionDialog: AlertDialog? = null
    open fun showSettingDialog(fragment: FragmentActivity) {
        try {
            val mPackName = fragment.packageName
            if (mPermissionDialog == null) {
                mPermissionDialog = AlertDialog.Builder(fragment)
                    .setMessage(getString(R.string.permission_open_tips))
                    .setPositiveButton(getString(R.string.setting_title)) { _: DialogInterface?, _: Int ->
                        val packageURI = Uri.parse("package:$mPackName")
                        val intent =
                            Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI)
                        startActivity(intent)
                    }
                    .setNegativeButton(getString(R.string.cancel_tv)) { _: DialogInterface?, _: Int ->
                        //关闭页面或者做其他操作
                        mPermissionDialog!!.dismiss()
                    }
                    .create()
            }
            if (mPermissionDialog != null && !mPermissionDialog!!.isShowing) {
                mPermissionDialog!!.show()
            }
        } catch (e: Exception) {

        }
    }


    val rxPermissions: RxPermissions by lazy {
        RxPermissions(this)
    }

    protected fun requestPerMission() {
        rxPermissions.requestEachCombined(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
        )
            .subscribe { permission: Permission ->
                when {
                    permission.granted -> {

                    }
                    permission.shouldShowRequestPermissionRationale -> {
                    }
                    else -> {
                        showSettingDialog(this)
                    }
                }
            }
    }

    @JvmOverloads
    fun jump2Page(intent: Intent, context: Context = this) {
        startActivity(intent)
    }

}