package com.cookandroid.shoppi_android.repository.category

import com.cookandroid.shoppi_android.model.Category

interface CategoryDataSource {

    suspend fun getCategories():List<Category>
}