package com.mercari.mercaritest.ui.contracts

import com.mercari.mercaritest.data.models.DataModel

interface FragmentContract {

    interface View {
        fun showProgress()
        fun hideProgress()
        fun getUrl(): String
        fun showData(t: List<DataModel>)

    }
}