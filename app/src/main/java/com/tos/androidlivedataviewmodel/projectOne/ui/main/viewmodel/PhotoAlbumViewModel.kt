package com.tos.androidlivedataviewmodel.projectOne.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.tos.androidlivedataviewmodel.projectOne.data.model.PhotoModel
import com.tos.androidlivedataviewmodel.projectOne.data.repository.PhotoAlbumRepository
import com.tos.androidlivedataviewmodel.projectOne.utils.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *Created by tarikul on 16/9/20
 */

class PhotoAlbumViewModel(var photoAlbumRepository: PhotoAlbumRepository) : ViewModel() {

    private var photoAlbum = MutableLiveData<Resource<List<PhotoModel>>>();

    fun getAllPhotos() = viewModelScope.launch {
        photoAlbum.postValue(Resource.loading(data = null))
        photoAlbumRepository.getPhotoAlbum()
            .catch { photoAlbum.postValue(Resource.error(null, "Error Occurred")) }
            .collect { photoAlbum.postValue(Resource.success(it)) }


        /* emit(Resource.loading(data = null))
         try {
             emit(Resource.success(data = photoAlbumRepository.getPhotoAlbum()))
         } catch (exception: Exception) {
             emit(Resource.error(data = null, message = exception.message ?: "Error Occurred"))
         }*/
    }

    private fun getPhotoData(): MutableLiveData<Resource<List<PhotoModel>>> {
        return photoAlbum
    }
}