package com.example.mygankkotlin.ui.activity

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.example.mygankkotlin.R

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/19
 */
abstract class BaseBindingActivity<B: ViewDataBinding>: AppCompatActivity() {

    lateinit var mBinding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = createDataBinding(savedInstanceState)

        initView()
    }

    abstract fun initView()

    abstract fun createDataBinding(savedInstanceState: Bundle?): B

    fun setupToolbar(toolbar: Toolbar){
        toolbar.title = ""
        toolbar.setNavigationIcon(R.mipmap.ic_launcher)
        setSupportActionBar(toolbar)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}