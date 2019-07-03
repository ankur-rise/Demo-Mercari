package com.mercari.mercaritest.di.modules

import com.mercari.mercaritest.data.network.Apis
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://s3-ap-northeast-1.amazonaws.com/m-et/Android/json/"

@Module
class NetworkModule {

    @Provides
    fun getApis(retrofit: Retrofit): Apis {
        return retrofit.create(Apis::class.java)
    }
    @Provides
    fun getRetrofitInstance(gsonConverterFactory: GsonConverterFactory, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
    @Provides
    fun gethttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS).build()
        return httpClient
    }
    @Provides
    fun getGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
    @Provides
    fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

}