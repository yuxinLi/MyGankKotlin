package com.example.mygankkotlin.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.example.mygankkotlin.R
import com.example.mygankkotlin.bean.FuckGoods
import com.example.mygankkotlin.databinding.ActivityMainBinding
import com.example.mygankkotlin.di.component.RandomModule
import com.example.mygankkotlin.getMainComponent
import com.example.mygankkotlin.mvp.contract.RandomContract
import com.example.mygankkotlin.mvp.presenter.RandomPresenter
import com.example.mygankkotlin.rooter.GankClientUri
import com.example.mygankkotlin.rooter.GankRouter
import com.example.mygankkotlin.toast
import com.example.mygankkotlin.ui.fragment.AndroidFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URLEncoder
import javax.inject.Inject

class MainActivity : BaseBindingActivity<ActivityMainBinding>() , RandomContract.View {

    lateinit var mFragments: MutableList<Fragment>

    @Inject
    lateinit var mPresenter: RandomPresenter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initView() {
        initFragmets()

        getMainComponent().plus(RandomModule(this)).inject(this)

        viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager){
            override fun getItem(position: Int) = mFragments[position]
            override fun getCount() = mFragments.size
        }
        viewPager.offscreenPageLimit =  mFragments.size

        navigationView.setOnNavigationItemSelectedListener {
            item ->
            var tab = 0
            when(item.itemId){
                R.id.menu_android -> tab = 0
                R.id.menu_ios -> tab = 1
                R.id.menu_girl -> tab = 2
                R.id.menu_about -> tab = 3
            }
            viewPager.currentItem = tab
            false
        }

        floatingButton.setOnClickListener {
            mPresenter.getRandom("Android")
        }

    }

    override fun createDataBinding(savedInstanceState: Bundle?): ActivityMainBinding {
        return DataBindingUtil.setContentView(this ,R.layout.activity_main)
    }

    override fun onRandom(goods: FuckGoods) {
        val url = URLEncoder.encode(goods.url)
        toast("手气不错～")
        GankRouter.router(this, GankClientUri.DETAIL + url)
    }

    private fun initFragmets(){
        mFragments = ArrayList()
        mFragments.add(AndroidFragment.newInstance())
        mFragments.add(AndroidFragment.newInstance())
        mFragments.add(AndroidFragment.newInstance())
        mFragments.add(AndroidFragment.newInstance())

    }
}
