package com.mercari.mercaritest.domain

import com.mercari.mercaritest.data.models.DataModel
import com.mercari.mercaritest.data.models.RawDataModel

interface IDataRepo {

    fun getRawData(callback: RepoCallback<List<RawDataModel>>)
    fun getData(url:String, callback: RepoCallback<List<DataModel>>)


    interface RepoCallback<in T> {
        fun onSuccess(t:T)
        fun onError(msg:String)
    }
}