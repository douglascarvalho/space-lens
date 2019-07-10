package com.douglas.spacelens

import android.app.Application
import com.douglas.spacelens.injection.ApplicationComponent
import com.douglas.spacelens.injection.DaggerApplicationComponent
import com.douglas.spacelens.injection.DaggerComponentProvider
import com.douglas.spacelens.injection.NetworkModule

class SpaceLensApplication: Application(), DaggerComponentProvider {

    override val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().networkModule(NetworkModule).build()
    }

}