package com.mercari.mercaritest.ui.contracts

import com.mercari.mercaritest.data.models.RawDataModel

interface IMainContract {

    interface View {
        fun showProgress()
        fun hideProgress()
        fun dataReceived(dataModel: List<RawDataModel>)

    }

}