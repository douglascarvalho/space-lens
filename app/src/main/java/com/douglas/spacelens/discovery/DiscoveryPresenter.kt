package com.douglas.spacelens.discovery

import android.util.Log
import com.douglas.spacelens.api.NasaApi
import com.douglas.spacelens.model.Picture
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DiscoveryPresenter @Inject constructor(
    private val nasaApi: NasaApi
) : DiscoveryContract.Presenter {

    private var disposable = Disposables.empty()
    private lateinit var view: DiscoveryContract.View

    override fun attach(view: DiscoveryContract.View) {
        this.view = view
    }

    override fun detach() {
        disposable.dispose()
    }

    override fun loadImages() {
        disposable = nasaApi.search("galaxy")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
            {imageResponse -> postImages(imageResponse)},
            {error -> Log.e("Search API Error", error.message)}
        )
    }

    private fun postImages(pictures: List<Picture>) {
        view.showImages()
    }
}