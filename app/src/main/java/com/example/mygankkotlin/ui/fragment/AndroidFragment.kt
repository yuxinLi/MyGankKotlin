package com.example.mygankkotlin.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mygankkotlin.bean.FuckGoods
import com.example.mygankkotlin.databinding.ViewRecyclerBinding
import com.example.mygankkotlin.di.component.FuckGoodsModule
import com.example.mygankkotlin.getMainComponent
import com.example.mygankkotlin.mvp.contract.FuckGoodsContract
import com.example.mygankkotlin.mvp.presenter.FuckGoodsPresenter
import com.example.mygankkotlin.rooter.GankClientUri
import com.example.mygankkotlin.rooter.GankRouter
import com.example.mygankkotlin.ui.adapter.FuckGoodsAdapter
import java.net.URLEncoder
import javax.inject.Inject

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/19
 */
class AndroidFragment : BaseBindingFragment<ViewRecyclerBinding>() , FuckGoodsContract.View{

    private var mList = ArrayList<FuckGoods>()
    private lateinit var mAdapter: FuckGoodsAdapter
    private var mPage = 1
    @Inject
    lateinit var mPresenter: FuckGoodsPresenter

    override fun setData(result: List<FuckGoods>) {
        mList.addAll(result)
        mAdapter.notifyDataSetChanged()
    }

    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): ViewRecyclerBinding {
        return ViewRecyclerBinding.inflate(inflater , container , false)
    }

    override fun initView() {
        mAdapter = FuckGoodsAdapter(mList)
        context.getMainComponent().plus(FuckGoodsModule(this)).inject(this)
        with(mBinding!!){
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(context)

            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView?.canScrollVertically(1)!!){
                        mPresenter.getData(++mPage , "ANDROID")
                    }
                }
            })
        }

        mPresenter.getData(mPage , "ANDROID")

        mAdapter.setOnItemClickListener {
            pos ->
            var url = URLEncoder.encode(mList[pos].url)
            GankRouter.router(context, GankClientUri.DETAIL + url)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unSubscribe()
    }

    companion object{
        val ANDROID = "ANDROID"

        fun newInstance(): AndroidFragment{
            val fragment = AndroidFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}