package com.example.mygankkotlin.di.component

import com.example.mygankkotlin.ui.activity.MainActivity
import com.example.mygankkotlin.mvp.contract.RandomContract
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */

@Subcomponent(modules = arrayOf(RandomModule::class))
interface RandomComponent{
    fun inject(activity: MainActivity)
}

@Module
class RandomModule(private val mView: RandomContract.View){
    @Provides
    fun getView() = mView
}