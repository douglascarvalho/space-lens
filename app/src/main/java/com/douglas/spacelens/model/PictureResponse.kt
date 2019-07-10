package com.douglas.spacelens.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PictureResponse (
    val collection: PictureCollection
)

@JsonClass(generateAdapter = true)
data class PictureCollection (
    val items: List<PictureDomain>
)

@JsonClass(generateAdapter = true)
data class PictureDomain(
    val data: List<PictureData>,
    val links: List<PictureLink>
)

data class PictureLink(
    val href: String
)

@JsonClass(generateAdapter = true)
data class PictureData (
    @Json(name = "nasa_id")
    val id: String,
    val title: String,
    val description: String
)
