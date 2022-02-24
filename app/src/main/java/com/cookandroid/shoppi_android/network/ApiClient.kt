package com.cookandroid.shoppi_android.network

import com.cookandroid.shoppi_android.model.Category
import com.cookandroid.shoppi_android.model.CategoryDetail
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {

    @GET("categories.json")
    suspend fun getCategories():List<Category>


    @GET("fashion_female.json")
    suspend fun getCategoryDetail():CategoryDetail




    companion object{
        private const val baseUrl = "https://shoppi-e916f-default-rtdb.asia-southeast1.firebasedatabase.app/"

        fun create():ApiClient{
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}