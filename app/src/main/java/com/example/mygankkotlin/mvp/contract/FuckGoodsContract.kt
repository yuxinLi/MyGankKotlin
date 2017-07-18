package com.example.mygankkotlin.mvp.contract

import com.example.mygankkotlin.bean.FuckGoods
import com.example.mygankkotlin.bean.JsonResult
import rx.Observable

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */
interface FuckGoodsContract {
    interface View{
        fun setData(result: List<FuckGoods>)
    }

    interface Model{
        fun getData(page: Int , type: String): Observable<JsonResult<List<FuckGoods>>>
    }

    interface Presenter{
        open fun getData(page: Int , type: String)
    }

}

