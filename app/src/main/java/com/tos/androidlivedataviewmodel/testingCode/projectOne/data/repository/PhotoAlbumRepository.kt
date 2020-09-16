package com.tos.androidlivedataviewmodel.testingCode.projectOne.data.repository

import com.tos.myapplication.data.api.ApiHelper

/**
 *Created by tarikul on 16/9/20
 */

class PhotoAlbumRepository(private var apiHelper: ApiHelper) {

    fun getPhotoAlbum ()= apiHelper.getPhotoAlbum()
}