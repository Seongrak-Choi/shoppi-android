package com.cookandroid.shoppi_android.repository.category

import com.cookandroid.shoppi_android.model.Category

class CategoryRepository(private val remoteDataSource: CategoryRemoteDataSource) {

    suspend fun getCategories():List<Category>{
        return remoteDataSource.getCategories()
    }
}