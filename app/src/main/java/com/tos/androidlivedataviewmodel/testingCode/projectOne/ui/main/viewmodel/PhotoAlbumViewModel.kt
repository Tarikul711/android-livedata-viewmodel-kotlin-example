package com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tos.androidlivedataviewmodel.testingCode.projectOne.data.model.PhotoModel
import com.tos.androidlivedataviewmodel.testingCode.projectOne.data.repository.PhotoAlbumRepository
import com.tos.androidlivedataviewmodel.testingCode.projectOne.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

/**
 *Created by tarikul on 16/9/20
 */

class PhotoAlbumViewModel(var photoAlbumRepository: PhotoAlbumRepository) : ViewModel() {

    var photoAlbums = MutableLiveData<List<PhotoModel>>()
    fun getPhotoAlbum() = CoroutineScope(Dispatchers.IO).launch {
        photoAlbums.postValue(photoAlbumRepository.getPhotoAlbum())
    }

   fun getAllPhotos()= liveData {
       emit(Resource.loading(data = null))
       try {
          emit(Resource.success(data = photoAlbumRepository.getPhotoAlbum()))
       }catch (exception:Exception){
           emit(Resource.error(data = null,message = exception.message?:"Error Occurred"))
       }
   }
}