package com.example.mygankkotlin

import android.app.Application
import com.example.mygankkotlin.di.component.ApiComponent
import com.example.mygankkotlin.di.component.DaggerApiComponent
import com.example.mygankkotlin.di.module.ApiModule
import com.example.mygankkotlin.di.module.AppModule
import javax.inject.Inject

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */
class App: Application() {

    init {
        instance = this
    }

    @Inject
    lateinit var apiComponent: ApiComponent

    override fun onCreate() {
        super.onCreate()

        DaggerApiComponent.builder()
                .apiModule(ApiModule())
                .appModule(AppModule(this))
                .build()
                .inject(this)
    }



    companion object{
        lateinit var instance: App
    }

}