package com.cookandroid.shoppi_android.repository.categorydetail

import com.cookandroid.shoppi_android.model.CategoryDetail
import com.cookandroid.shoppi_android.network.ApiClient

class CategoryDetailRemoteDataSource(private val api:ApiClient):CategoryDetailDateSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }
}