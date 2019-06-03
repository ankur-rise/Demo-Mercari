package com.mercari.mercaritest.ui.presenter

import com.mercari.mercaritest.data.models.RawDataModel
import com.mercari.mercaritest.domain.IDataRepo
import com.mercari.mercaritest.domain.usecases.IDataUseCase
import com.mercari.mercaritest.ui.contracts.IMainContract
import javax.inject.Inject

class MainPresenter @Inject constructor(useCase: IDataUseCase) :BasePresenter<IMainContract.View>() {
    private val mUseCase = useCase
    override fun start() {
        mView!!.showProgress()
        mUseCase.getRawData(object : IDataRepo.RepoCallback<List<RawDataModel>>{
            override fun onSuccess(dataModel: List<RawDataModel>) {
                mView!!.dataReceived(dataModel)
                mView!!.hideProgress()
            }

            override fun onError(msg: String) {
                mView!!.hideProgress()
            }

        })
    }
}