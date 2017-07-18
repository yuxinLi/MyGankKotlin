package com.example.mygankkotlin.mvp.presenter

import com.example.mygankkotlin.mvp.contract.RandomContract
import com.example.mygankkotlin.mvp.model.RandomModel
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */
class RandomPresenter
@Inject
constructor(private val mModel: RandomModel,
            private val mView: RandomContract.View): RandomContract.Presenter , BasePresenter() {

    override fun getRandom(type: String) {
        addSubscription(mModel.getRandom(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            res ->
                            if (!res.error){
                                mView.onRandom(res.results[0])
                            }
                        },
                        {}
                ))
    }
}