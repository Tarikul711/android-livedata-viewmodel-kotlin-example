package com.tos.androidlivedataviewmodel.projectOne.data.repository

import com.tos.myapplication.data.api.ApiHelper

/**
 *Created by tarikul on 16/9/20
 */

class PhotoAlbumRepository(private var apiHelper: ApiHelper) {

    suspend fun getPhotoAlbum ()= apiHelper.getPhotoAlbum()
}