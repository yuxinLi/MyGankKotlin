package com.example.mygankkotlin.mvp.contract

import com.example.mygankkotlin.bean.FuckGoods
import com.example.mygankkotlin.bean.JsonResult
import rx.Observable

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */
interface RandomContract {

    interface View{
        fun onRandom(goods: FuckGoods)
    }

    interface Model{
        fun getRandom(type: String): Observable<JsonResult<List<FuckGoods>>>
    }

    interface Presenter{
        fun getRandom(type: String)
    }
}