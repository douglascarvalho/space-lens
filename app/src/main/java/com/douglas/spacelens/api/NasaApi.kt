package com.douglas.spacelens.api

import com.douglas.spacelens.model.Picture
import io.reactivex.Observable
import retrofit2.http.GET

interface NasaApi {

    @GET("/search")
    fun search(): Observable<List<Picture>>

}