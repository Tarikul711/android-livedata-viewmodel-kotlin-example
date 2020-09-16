package com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tos.androidlivedataviewmodel.testingCode.projectOne.data.model.PhotoModel
import com.tos.androidlivedataviewmodel.testingCode.projectOne.data.repository.PhotoAlbumRepository

/**
 *Created by tarikul on 16/9/20
 */

class PhotoAlbumViewModel(var photoAlbumRepository: PhotoAlbumRepository) : ViewModel() {

    var photoAlbums = MutableLiveData<List<PhotoModel>>()

    fun getPhotoAlbum() {
        photoAlbums.value = photoAlbumRepository.getPhotoAlbum()
    }
}