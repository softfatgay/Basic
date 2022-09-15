package com.basic.demo.webview

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.basic.Constants
import com.basic.demo.base.BaseActivity
import com.basic.demo.databinding.ActivityWebviewBinding
import com.basic.demo.model.TagListItem

class WebViewActivity : BaseActivity() {

    private val binding by lazy {
        ActivityWebviewBinding.inflate(layoutInflater)
    }

    private val url by lazy {
        intent.getStringExtra(Constants.URL_EXTRA)
    }

    override val layout: View
        get() = binding.root

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        getData()

        if (savedInstanceState == null) {
            val webBundle = Bundle()
            webBundle.putString(Constants.URL_EXTRA, "$url")
            supportFragmentManager.beginTransaction()
                .add(binding.fragmentContainerView.id, WebViewFragment().apply {
                    arguments = webBundle
                }).commit()

        }
    }

    private fun getData() {
        val list = intent.getSerializableExtra("list") as ArrayList<*>

//        val list = intent.getParcelableArrayExtra("list") as ArrayList<TagListItem>
        Log.e("---------", "${list.size}")
    }
}