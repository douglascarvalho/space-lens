package com.douglas.spacelens.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PictureResponse (
    val collection: PictureCollection
)

@JsonClass(generateAdapter = true)
data class PictureCollection (
    val items: List<Picture>
)