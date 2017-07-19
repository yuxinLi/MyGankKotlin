package com.example.mygankkotlin.ui.fragment

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/19
 */
abstract class BaseBindingFragment<B:ViewDataBinding>: Fragment() {

    lateinit var mBinding: B

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        mBinding = createDataBinding(inflater , container , savedInstanceState)
        initView()
        return mBinding.root
    }

    abstract fun createDataBinding(inflater: LayoutInflater? , container: ViewGroup?, savedInstanceState: Bundle?) : B

    abstract fun initView()
}