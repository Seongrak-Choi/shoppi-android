package com.cookandroid.shoppi_android

import android.content.Context
import android.util.Log

class AssetLoader(private val context: Context) {

    fun getJsonString(fileName:String):String?{
        return kotlin.runCatching {
            loadAsset(fileName)
        }.getOrNull()
    }

    private fun loadAsset(fileName:String):String {
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size) //받아온 바이트사이즈 만큼 바이트어레이를 생성
            inputStream.read(bytes) //받아온 데이터를 읽어서 bytes에 저장
            String(bytes)
        }
    }
}