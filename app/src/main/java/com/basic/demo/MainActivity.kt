package com.basic.demo

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.basic.demo.base.BaseActivity
import com.basic.demo.databinding.ActivityMainBinding
import com.basic.demo.model.TagListItem
import com.basic.demo.viewModel.MainViewModel
import com.basic.demo.webview.WebViewActivity
import com.example.net.viewmodel.UIStatus

class MainActivity : BaseActivity(), View.OnClickListener {

    override val layout: View
        get() = binding.root

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun initView() {
        super.initView()

        Thread {
            binding.btnWeb.visibility = View.VISIBLE
        }.start()
    }

    override fun initEvent() {
        super.initEvent()
        binding.btn.setOnClickListener(this)
        binding.btnWeb.setOnClickListener(this)
    }

    override fun reTry() {
        super.reTry()
        getData()
    }

    override fun initData() {
        super.initData()
        viewModel.UIState.observ(this) {
            when (it) {
                UIStatus.CONTENT -> mStateView.showContent()
                UIStatus.LOADING -> mStateView.showLoading()
                UIStatus.RETRY -> mStateView.showRetry()
                else -> mStateView.showContent()
            }
        }

        viewModel.homeData.observe(this) {
            binding.tv.text = it
            binding.tv.movementMethod = ScrollingMovementMethod.getInstance()
        }
    }

    private fun getData() {
        viewModel.testData()
    }

    override fun onClick(v: View) {
        when (v) {
            binding.btn -> getData()
            binding.btnWeb -> goWebView()
        }
    }

    private fun goWebView() {
        val intent = Intent(this, WebViewActivity::class.java)

        val tagListItems = ArrayList<TagListItem>()

        tagListItems.add(TagListItem())
        tagListItems.add(TagListItem())
        tagListItems.add(TagListItem())
        tagListItems.add(TagListItem())
        tagListItems.add(TagListItem())

        val bundle = Bundle()
        bundle.putSerializable("list", tagListItems)
        intent.putExtras(bundle)

        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        val b = 2
        val c = 3
    }
}
