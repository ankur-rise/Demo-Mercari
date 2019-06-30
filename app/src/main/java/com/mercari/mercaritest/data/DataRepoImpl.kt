package com.mercari.mercaritest.data

import com.mercari.mercaritest.data.models.DataModel
import com.mercari.mercaritest.data.models.RawDataModel
import com.mercari.mercaritest.data.network.Apis
import com.mercari.mercaritest.domain.IDataRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DataRepoImpl @Inject constructor(api: Apis) : IDataRepo {


    val mApis: Apis = api
    override fun getData(url: String, callback: IDataRepo.RepoCallback<List<DataModel>>) {

        val call = mApis.getData(url)
        call.enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(call: Call<List<DataModel>>, response: Response<List<DataModel>>) {
                callback.onSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                callback.onError(t.message!!)
            }


        })
    }

    override fun getRawData(callback: IDataRepo.RepoCallback<List<RawDataModel>>) {
        val call = mApis.getUrls()
        call.enqueue(object : Callback<List<RawDataModel>> {
            override fun onResponse(call: Call<List<RawDataModel>>, response: Response<List<RawDataModel>>) {
                callback.onSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<List<RawDataModel>>, t: Throwable) {
                callback.onError(t.message!!)
            }


        })
    }

}