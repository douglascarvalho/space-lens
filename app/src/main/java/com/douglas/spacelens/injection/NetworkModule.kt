package com.douglas.spacelens.injection

import com.douglas.spacelens.api.NasaApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://images-api.nasa.gov/"

@Module
object NetworkModule {

    @Provides
    internal fun provideNasaApi(retrofit: Retrofit): NasaApi = retrofit.create(NasaApi::class.java)

    @Provides
    internal fun provideRetrofitInterface(): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()

}