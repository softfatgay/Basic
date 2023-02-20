package com.basic.demo.webview

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import com.basic.demo.base.BaseFragment
import com.basic.demo.databinding.FragmentWebviewBinding
import com.example.basic.Constants.URL_EXTRA

class WebViewFragment : BaseFragment() {

    private val url: String by lazy {
        requireArguments().getString(URL_EXTRA) as String
    }

    val webSetting by lazy { binding.webView.settings }

    private val binding by lazy {
        FragmentWebviewBinding.inflate(layoutInflater)
    }

    override fun getRootView(inflater: LayoutInflater, container: ViewGroup?): View {
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView() {
        val webSetting = binding.webView.settings

        webSetting.domStorageEnabled = true

        webSetting.allowFileAccess = true

        webSetting.javaScriptEnabled = true

        webSetting.cacheMode = WebSettings.LOAD_DEFAULT

        Log.e("------------", url)

        binding.webView.loadUrl(url)

        binding.webView.webChromeClient = webChromeClient

        binding.webView.webViewClient = webViewClient
    }

    private val webChromeClient = object : WebChromeClient() {
        override fun onReceivedTitle(view: WebView?, title: String?) {
            super.onReceivedTitle(view, title)
        }

        override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
            return super.onConsoleMessage(consoleMessage)
        }

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
        }
    }

    private val webViewClient = object : WebViewClient() {

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            webSetting.blockNetworkImage = true
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            webSetting.blockNetworkImage = false
            super.onPageFinished(view, url)
        }
    }
}