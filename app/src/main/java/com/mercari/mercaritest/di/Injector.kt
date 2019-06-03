package com.mercari.mercaritest.di

import android.util.Log
import com.mercari.mercaritest.di.components.DaggerIActivityComponent
import com.mercari.mercaritest.di.components.IActivityComponent

object Injector {
    var compo: IActivityComponent

    init {
        compo = DaggerIActivityComponent.builder().build()
        Log.i(Injector::class.java.simpleName, "INIT")
    }

    fun getActivityCompo(): IActivityComponent {
        return compo
    }

}