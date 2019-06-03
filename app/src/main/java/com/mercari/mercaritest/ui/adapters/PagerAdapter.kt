package com.mercari.mercaritest.ui.adapters

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.mercari.mercaritest.data.models.RawDataModel
import com.mercari.mercaritest.ui.KEY_URL
import com.mercari.mercaritest.ui.fragments.DealFragment

class PagerAdapter(fm: FragmentManager?, data: List<RawDataModel>) : FragmentPagerAdapter(fm) {
    private val mData = data
    override fun getItem(pos: Int): Fragment {
        lateinit var fragment: Fragment
        val bundle = Bundle()
        when (pos) {
            0 -> {
                fragment = DealFragment()
                bundle.putString(KEY_URL, mData.get(1).data)
            }
            1 -> {
                fragment = DealFragment()
                bundle.putString(KEY_URL, mData.get(0).data)
            }
            2 -> {
                fragment = DealFragment()
                bundle.putString(KEY_URL, mData.get(2).data)
            }
        }


        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {

        when (position) {
            0 -> return "Men"
            1 -> return "All"
            2 -> return "Women"
        }

        return super.getPageTitle(position)
    }
}