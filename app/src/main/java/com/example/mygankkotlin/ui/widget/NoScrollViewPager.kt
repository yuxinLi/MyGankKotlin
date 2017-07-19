package com.example.mygankkotlin.ui.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/19
 */
class NoScrollViewPager: ViewPager {

    private val isPagingEnabled = false

    constructor(context: Context): super(context)

    constructor(context: Context , attrs: AttributeSet): super(context,attrs)

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return this.isPagingEnabled && super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return this.isPagingEnabled && super.onInterceptTouchEvent(ev)
    }
}