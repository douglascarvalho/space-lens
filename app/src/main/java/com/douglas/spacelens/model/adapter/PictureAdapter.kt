package com.douglas.spacelens.model.adapter

import com.douglas.spacelens.model.Picture
import com.douglas.spacelens.model.PictureResponse
import com.squareup.moshi.FromJson

class PictureAdapter {

    @FromJson
    fun fromJson(pictureResponse: PictureResponse): List<Picture> {
        val list = mutableListOf<Picture>()
        pictureResponse.collection.items.map {
            val data = it.data.first()
            val link = it.links.first()
            list.add(
                Picture(
                    data.id,
                    data.title,
                    data.description,
                    link.href
                )
            )
        }
        return list
    }

}