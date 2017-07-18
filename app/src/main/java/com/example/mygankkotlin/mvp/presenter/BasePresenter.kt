package com.example.mygankkotlin.mvp.presenter

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */
open class BasePresenter {

    var compositeSubscription = CompositeSubscription()

    protected fun addSubscription(subscription: Subscription){
        compositeSubscription.add(subscription)
    }

    fun unSubscribe(){
        if (compositeSubscription.hasSubscriptions()){
            compositeSubscription.unsubscribe()
        }
    }
}