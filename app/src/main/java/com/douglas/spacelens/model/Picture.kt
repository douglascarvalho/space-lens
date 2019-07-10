package com.douglas.spacelens.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Picture(
    val data: List<PictureData>,
    val href: String
)

@JsonClass(generateAdapter = true)
data class PictureData (
    @Json(name = "nasa_id")
    val id: String
)