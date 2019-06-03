package com.mercari.mercaritest.ui.presenter

abstract class BasePresenter<T> {
    var mView:T?=null

    fun bindView(view:T) {
        mView = view
    }

    abstract fun start()
}