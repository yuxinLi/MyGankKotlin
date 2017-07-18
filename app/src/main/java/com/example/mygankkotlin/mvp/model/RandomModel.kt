package com.example.mygankkotlin.mvp.model

import com.example.mygankkotlin.api.GankApi
import com.example.mygankkotlin.bean.FuckGoods
import com.example.mygankkotlin.bean.JsonResult
import com.example.mygankkotlin.mvp.contract.RandomContract
import rx.Observable
import javax.inject.Inject

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */
class RandomModel
    @Inject
    constructor(private val api: GankApi): RandomContract.Model {
    override fun getRandom(type: String): Observable<JsonResult<List<FuckGoods>>> {
        return api.getRandom(type)
    }
}