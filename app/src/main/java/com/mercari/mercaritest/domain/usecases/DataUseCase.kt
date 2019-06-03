package com.mercari.mercaritest.domain.usecases

import com.mercari.mercaritest.data.models.DataModel
import com.mercari.mercaritest.data.models.RawDataModel
import com.mercari.mercaritest.domain.IDataRepo
import javax.inject.Inject

open class DataUseCase @Inject constructor(repo:IDataRepo):IDataUseCase{
private val mRepo = repo

    override fun getRawData(callback:IDataRepo.RepoCallback<List<RawDataModel>>){
        mRepo.getRawData(callback)
    }

    override fun getData(url:String, callback: IDataRepo.RepoCallback<List<DataModel>>){
        mRepo.getData(url, callback)
    }

}