package com.example.mygankkotlin.di.component

import com.example.mygankkotlin.App
import com.example.mygankkotlin.di.module.ApiModule
import dagger.Component

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */

@Component(modules = arrayOf(ApiModule::class))
interface ApiComponent {

    fun inject(app: App)
    fun plus(module: FuckGoodsModule): FuckGoodsComponent
    fun plus(module: RandomModule): RandomComponent
}