package com.mercari.mercaritest.di.modules

import com.mercari.mercaritest.data.DataRepoImpl
import com.mercari.mercaritest.domain.IDataRepo
import com.mercari.mercaritest.domain.usecases.DataUseCase
import com.mercari.mercaritest.domain.usecases.IDataUseCase
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepoModule {

    @Binds @Singleton
    abstract fun getRepo(repo:DataRepoImpl) :IDataRepo
    @Binds @Singleton
    abstract fun getUseCase(repo:DataUseCase) :IDataUseCase
}