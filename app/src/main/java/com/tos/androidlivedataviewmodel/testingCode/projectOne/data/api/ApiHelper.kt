package com.tos.myapplication.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPhotoAlbum() = apiService.getPhotoAlbum()

}