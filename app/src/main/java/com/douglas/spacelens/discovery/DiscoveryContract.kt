package com.douglas.spacelens.discovery

import com.douglas.spacelens.base.BasePresenter
import com.douglas.spacelens.base.BaseView

class DiscoveryContract {

    interface View: BaseView {
        fun showImages()
    }

    interface Presenter: BasePresenter<View> {
        fun loadImages()
    }

}