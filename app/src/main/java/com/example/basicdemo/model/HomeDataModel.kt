package com.example.basicdemo.model

data class HomeDataModel(
    val tagList: List<TagListItem>? = null
)

data class TagListItem(
    val floorPrice: Number? = null,
    val picUrl: String? = null,
    val newOnShelf: Boolean? = null,
    val webIndexVerticalPicUrl: String? = null,
    val simpleDesc: String? = null,
    val name: String? = null,
    val appListPicUrl: String? = null,
    val id: Number? = null,
)