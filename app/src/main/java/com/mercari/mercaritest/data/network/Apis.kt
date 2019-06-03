package com.mercari.mercaritest.data.network

import com.mercari.mercaritest.data.models.DataModel
import com.mercari.mercaritest.data.models.RawDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface Apis {

    @GET("master.json")
    fun getUrls(): Call<List<RawDataModel>>

    @GET
    fun getData(@Url url:String) : Call<List<DataModel>>

}