package com.cookandroid.shoppi_android.repository.category

import com.cookandroid.shoppi_android.model.Category
import com.cookandroid.shoppi_android.network.ApiClient

class CategoryRemoteDataSource(private val apiClient:ApiClient): CategoryDataSource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}