package com.cookandroid.shoppi_android.repository.home

import com.cookandroid.shoppi_android.model.HomeData

interface HomeDataSource {

    fun getHomeData() : HomeData?
}