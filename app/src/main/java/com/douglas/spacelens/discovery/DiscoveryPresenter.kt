package com.douglas.spacelens.discovery

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.douglas.spacelens.api.NasaApi
import com.douglas.spacelens.model.Picture
import com.douglas.spacelens.model.PictureResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DiscoveryPresenter @Inject constructor(
    private val nasaApi: NasaApi
) : DiscoveryContract.Presenter {

    private lateinit var view: DiscoveryContract.View

    private val pictures = MutableLiveData<Picture>()
    fun pictures(): LiveData<Picture> = pictures

    override fun attach(view: DiscoveryContract.View) {
        this.view = view
    }

    override fun detach() {}

    override fun loadImages() {
        nasaApi.search("galaxy")
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