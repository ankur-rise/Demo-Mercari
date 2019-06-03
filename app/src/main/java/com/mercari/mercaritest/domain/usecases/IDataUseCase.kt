package com.mercari.mercaritest.domain.usecases

import com.mercari.mercaritest.data.models.DataModel
import com.mercari.mercaritest.data.models.RawDataModel
import com.mercari.mercaritest.domain.IDataRepo

interface IDataUseCase {
    fun getRawData(callback: IDataRepo.RepoCallback<List<RawDataModel>>)
    fun getData(url:String, callback: IDataRepo.RepoCallback<List<DataModel>>)
}