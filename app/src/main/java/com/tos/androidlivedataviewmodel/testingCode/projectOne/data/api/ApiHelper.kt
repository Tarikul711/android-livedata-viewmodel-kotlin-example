package com.tos.myapplication.data.api

class ApiHelper(private val apiService: ApiService) {

    fun getPhotoAlbum() = apiService.getPhotoAlbum()

}