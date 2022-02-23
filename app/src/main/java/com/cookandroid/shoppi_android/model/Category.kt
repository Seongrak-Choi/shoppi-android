package com.cookandroid.shoppi_android.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("category_id")val categoryId: String,
    @SerializedName("label")val label : String,
    @SerializedName("thumbnail_image_url")val thumbnailImageUrl : String,
    @SerializedName("updated")val updated : Boolean
    )