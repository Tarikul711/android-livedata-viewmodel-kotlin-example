package com.tos.androidlivedataviewmodel.projectOne.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tos.androidlivedataviewmodel.projectOne.data.repository.PhotoAlbumRepository
import com.tos.androidlivedataviewmodel.projectOne.utils.Resource

/**
 *Created by tarikul on 16/9/20
 */

class PhotoAlbumViewModel(var photoAlbumRepository: PhotoAlbumRepository) : ViewModel() {
    fun getAllPhotos() = liveData {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = photoAlbumRepository.getPhotoAlbum()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred"))
        }
    }
}