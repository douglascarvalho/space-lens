package com.douglas.spacelens.injection

import com.douglas.spacelens.api.NasaApi
import com.douglas.spacelens.discovery.DiscoveryPresenter
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun discoveryPresenter(nasaApi: NasaApi) = DiscoveryPresenter(nasaApi)

}