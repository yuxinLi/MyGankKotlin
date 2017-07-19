package com.example.mygankkotlin.ui

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/19
 */

@BindingAdapter("load_image")
fun loadImage(imageView: ImageView, url: String) =
        Glide.with(imageView.context).load(url)
                .crossFade()
                .into(imageView)



@BindingAdapter("load_asset")
fun loadAsset(imageView: ImageView , id: Int) =
        Glide.with(imageView.context).load(id).into(imageView)