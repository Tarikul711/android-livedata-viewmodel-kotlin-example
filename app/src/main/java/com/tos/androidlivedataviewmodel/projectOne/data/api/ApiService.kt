package com.tos.myapplication.data.api


import com.tos.androidlivedataviewmodel.projectOne.data.model.PhotoModel
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotoAlbum():List<PhotoModel>

}