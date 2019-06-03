package com.mercari.mercaritest.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.ProgressBar
import butterknife.BindView
import butterknife.ButterKnife
import com.mercari.mercaritest.R
import com.mercari.mercaritest.data.models.RawDataModel
import com.mercari.mercaritest.di.Injector
import com.mercari.mercaritest.ui.adapters.PagerAdapter
import com.mercari.mercaritest.ui.contracts.IMainContract
import com.mercari.mercaritest.ui.fragments.DealFragment
import com.mercari.mercaritest.ui.presenter.MainPresenter
import javax.inject.Inject

const val KEY_URL = "url"
class MainActivity : AppCompatActivity(), IMainContract.View ,
    DealFragment.OnListFragmentInteractionListener {
    override fun showProgress() {
        pb.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        pb.visibility = View.GONE
    }

    override fun dataReceived(datas: List<RawDataModel>) {
        initPager(datas)
    }

    override fun onListFragmentInteraction(item: String?) {

    }

    @BindView(R.id.pager)
    lateinit var viewpager: ViewPager
    @BindView(R.id.tablayout)
    lateinit var tabLayout: TabLayout
    @BindView(R.id.pb)
    lateinit var pb:ProgressBar

    @Inject
    lateinit var mPresnter:MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        val component = Injector.getActivityCompo()
        component.inject(this)
        mPresnter.bindView(this)
        mPresnter.start()

    }

    private fun initPager(datas: List<RawDataModel>) {

        var pagerAdapter = PagerAdapter(supportFragmentManager, datas)
        viewpager.adapter = pagerAdapter

        tabLayout.setupWithViewPager(viewpager)

    }
}
