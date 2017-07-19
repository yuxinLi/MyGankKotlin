package com.example.mygankkotlin.rooter

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */
object GankRouter {

    fun router(context: Context , uri: String){
        val intent = Intent()
        intent.data = Uri.parse(uri)
        intent.action = Intent.ACTION_VIEW
        context.startActivity(intent)
    }
}