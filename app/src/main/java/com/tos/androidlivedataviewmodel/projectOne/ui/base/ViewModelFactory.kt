package com.tos.androidlivedataviewmodel.projectOne.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tos.androidlivedataviewmodel.projectOne.data.repository.PhotoAlbumRepository
import com.tos.androidlivedataviewmodel.projectOne.ui.main.viewmodel.PhotoAlbumViewModel
import com.tos.myapplication.data.api.ApiHelper

/**
 *Created by tarikul on 16/9/20
 */
class ViewModelFactory(val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoAlbumViewModel::class.java)) {
            return PhotoAlbumViewModel(PhotoAlbumRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}