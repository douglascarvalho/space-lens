package com.douglas.spacelens.api

import com.douglas.spacelens.model.Picture
import com.douglas.spacelens.model.PictureResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {

    @GET("/search")
    fun search(@Query(value = "q") word: String): Observable<List<Picture>>

}