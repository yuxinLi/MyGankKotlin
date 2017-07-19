package com.example.mygankkotlin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mygankkotlin.bean.FuckGoods
import com.example.mygankkotlin.databinding.ItemFuckgoodsBinding

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/19
 */
class FuckGoodsAdapter (private val mList: List<FuckGoods>) : BaseBindingAdapter<ItemFuckgoodsBinding>() {
    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<ItemFuckgoodsBinding>?, position: Int) {
        super.onBindViewHolder(holder, position)

        holder!!.binding.fuckgoods = mList[position]
        holder.binding.executePendingBindings()

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DataBoundViewHolder<ItemFuckgoodsBinding> {
        return DataBoundViewHolder(ItemFuckgoodsBinding.inflate(LayoutInflater.from(parent!!.context) , parent , false))
    }
}