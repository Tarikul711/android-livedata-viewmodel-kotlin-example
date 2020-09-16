package com.tos.myapplication.data.api


import com.tos.androidlivedataviewmodel.testingCode.projectOne.data.model.PhotoModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("photos")
    fun getPhotoAlbum(): List<PhotoModel>

}