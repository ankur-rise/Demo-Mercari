package com.mercari.mercaritest.di.components

import com.mercari.mercaritest.di.modules.NetworkModule
import com.mercari.mercaritest.di.modules.RepoModule
import com.mercari.mercaritest.ui.MainActivity
import com.mercari.mercaritest.ui.fragments.DealFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, RepoModule::class]) @Singleton
interface IActivityComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: DealFragment)
}