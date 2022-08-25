package com.example.basicdemo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.nukc.stateview.StateView


abstract class BaseFragment : Fragment() {

    lateinit var mStateView: StateView

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = getRootView(inflater, container)
        mStateView = StateView.inject(rootView)
        mStateView.onRetryClickListener = object : StateView.OnRetryClickListener {
            override fun onRetryClick() {
                mStateView.showContent()
                reTry()
            }
        }
        return rootView
    }

    abstract fun getRootView(inflater: LayoutInflater, container: ViewGroup?): View


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        initEvent()
    }

    fun showContent(){
        mStateView.showContent()
    }

    fun showRetry(){
        mStateView.showRetry()
    }

    fun showLoading(){
        mStateView.showLoading()
    }

    abstract fun initView()

    open fun initData() {

    }

    open fun initEvent() {

    }

    open fun reTry() {}


}