package com.example.mygankkotlin.di.component

import com.example.mygankkotlin.mvp.contract.FuckGoodsContract
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */
@Subcomponent(modules = arrayOf(FuckGoodsModule::class))
interface FuckGoodsComponent{

//    fun inject(fragment: AndroidFragment)

}


@Module
class FuckGoodsModule(private val mView: FuckGoodsContract.View){
    @Provides
    fun getView() = mView
}