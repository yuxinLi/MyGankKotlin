package com.example.mygankkotlin.mvp.model

import com.example.mygankkotlin.api.GankApi
import com.example.mygankkotlin.bean.FuckGoods
import com.example.mygankkotlin.bean.JsonResult
import com.example.mygankkotlin.mvp.contract.FuckGoodsContract
import rx.Observable
import javax.inject.Inject

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */
class FuckGoodsModel

    @Inject
    constructor(private val api: GankApi) : FuckGoodsContract.Model {
    override fun getData(page: Int, type: String): Observable<JsonResult<List<FuckGoods>>> {
        when(type){
            "ANDROID" -> return api.getAndroidData(page)
            else ->return api.getAndroidData(page)
        }
    }
}