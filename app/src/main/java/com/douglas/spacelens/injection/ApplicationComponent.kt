package com.douglas.spacelens.injection

import com.douglas.spacelens.discovery.DiscoveryPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun getDiscoveryPresenter(): DiscoveryPresenter
}