package com.cookandroid.shoppi_android.repository

import com.cookandroid.shoppi_android.model.HomeData

interface HomeDataSource {

    fun getHomeData() : HomeData?
}