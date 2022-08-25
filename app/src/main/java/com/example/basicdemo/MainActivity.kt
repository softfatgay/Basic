package com.example.basicdemo

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.basicdemo.base.BaseActivity
import com.example.basicdemo.databinding.ActivityMainBinding
import com.example.basicdemo.viewModel.MainViewModel
import com.example.net.viewmodel.UIStatus
import com.google.gson.Gson

class MainActivity : BaseActivity(), View.OnClickListener {

    override val layout: View
        get() = binding.root

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun initEvent() {
        super.initEvent()
        binding.btn.setOnClickListener(this)
    }

    override fun reTry() {
        super.reTry()
        getData()
    }

    override fun initData() {
        super.initData()
        viewModel.UIState.observ(this){
            when (it) {
                UIStatus.CONTENT -> mStateView.showContent()
                UIStatus.LOADING -> mStateView.showLoading()
                UIStatus.RETRY -> mStateView.showRetry()
                else -> mStateView.showContent()
            }
        }

        viewModel.homeData.observe(this) {
            binding.tv.text = it
            binding.tv.movementMethod = ScrollingMovementMethod.getInstance();
        }
    }

    private fun getData() {
        viewModel.testData()
    }

    override fun onClick(v: View) {
        when (v) {
            binding.btn -> getData()
        }
    }
}