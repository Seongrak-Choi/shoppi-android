package com.cookandroid.shoppi_android.repository.categorydetail

import com.cookandroid.shoppi_android.model.CategoryDetail

interface CategoryDetailDateSource {

    suspend fun  getCategoryDetail(): CategoryDetail
}