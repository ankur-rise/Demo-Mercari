package com.mercari.mercaritest.ui.presenter

import com.mercari.mercaritest.data.models.DataModel
import com.mercari.mercaritest.domain.IDataRepo
import com.mercari.mercaritest.domain.usecases.DataUseCase
import com.mercari.mercaritest.ui.contracts.FragmentContract
import javax.inject.Inject

class DataPresenter @Inject constructor(useCase: DataUseCase) : BasePresenter<FragmentContract.View>() {
    private val mUseCase = useCase
    override fun start() {
        mView!!.showProgress()

        mUseCase.getData(mView!!.getUrl(), object : IDataRepo.RepoCallback<List<DataModel>>{
            override fun onSuccess(t: List<DataModel>) {
                mView!!.hideProgress()
                mView!!.showData(t)
            }

            override fun onError(msg: String) {
                mView!!.hideProgress()
            }

        })
    }



}