package com.cookandroid.shoppi_android.repository.home

import com.cookandroid.shoppi_android.model.HomeData

class HomeRepository(private val assetDataSource : HomeAssetDataSource) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}