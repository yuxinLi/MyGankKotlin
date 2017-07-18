package com.example.mygankkotlin.mvp.presenter

import android.util.Log
import com.example.mygankkotlin.mvp.contract.FuckGoodsContract
import com.example.mygankkotlin.mvp.model.FuckGoodsModel
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */
class FuckGoodsPresenter
    @Inject
    constructor(private val mModel: FuckGoodsModel,
                private val mView: FuckGoodsContract.View): FuckGoodsContract.Presenter , BasePresenter(){
    override fun getData(page: Int, type: String) {
        addSubscription(mModel.getData(page , type)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            res ->
                                if (!res.error){
                                    mView.setData(res.results)
                                }
                        } ,

                        {
                            e -> Log.e("wing", "error android Presenter , " + e.message)
                        }
                )
        )
    }
}