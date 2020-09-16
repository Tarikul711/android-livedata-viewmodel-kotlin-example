package com.tos.myapplication.data.api


import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("searchOld")
    suspend fun getProductsOld(@Body apiKey: ApiKeyModel): ProductModelOld

}