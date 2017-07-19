package com.example.mygankkotlin.ui.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/19
 */
abstract class BaseBindingAdapter< B: ViewDataBinding> : RecyclerView.Adapter<DataBoundViewHolder<B>>() {
    var mListener: ((pos: Int) -> Unit)? = null

    override fun onBindViewHolder(holder: DataBoundViewHolder<B>?, position: Int) {
        holder!!.binding.root.setOnClickListener {
            mListener?.invoke(holder.adapterPosition)
        }
    }

    fun setOnItemClickListener(listener: (pos: Int) -> Unit){
        mListener = listener
    }
}