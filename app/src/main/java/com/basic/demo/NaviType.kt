package com.basic.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.basic.demo.databinding.ActivityMainBinding
import com.basic.demo.market.OppoMarketCommentUtil
import com.basic.demo.market.VivoMarketCommentUtil
import com.basic.demo.viewModel.MainViewModel

class MainActivity : ComponentActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.oppo.setOnClickListener {
            OppoMarketCommentUtil.jumpToComment(this)
        }

        binding.vivo.setOnClickListener {
            VivoMarketCommentUtil.jumpToComment(this)
        }
    }
}
