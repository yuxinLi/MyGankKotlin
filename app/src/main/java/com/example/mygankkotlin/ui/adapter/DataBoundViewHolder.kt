package com.example.mygankkotlin.ui.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/19
 */
class DataBoundViewHolder<T: ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root){
}