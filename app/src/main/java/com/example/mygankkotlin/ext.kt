package com.example.mygankkotlin

import android.content.Context
import android.widget.Toast

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/19
 */


fun Context.getMainComponent() = App.instance.apiComponent

fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this , msg , length).show()
}