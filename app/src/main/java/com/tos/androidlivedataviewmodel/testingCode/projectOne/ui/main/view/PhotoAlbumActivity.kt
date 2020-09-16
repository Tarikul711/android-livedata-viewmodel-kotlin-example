package com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.tos.androidlivedataviewmodel.R
import com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.base.ViewModelFactory
import com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.main.viewmodel.PhotoAlbumViewModel
import com.tos.myapplication.data.api.ApiHelper
import com.tos.myapplication.data.api.RetrofitBuilder

class PhotoAlbumActivity : AppCompatActivity() {

    private lateinit var viewModel: PhotoAlbumViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_album)

        viewModel =
            ViewModelProvider(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))
                .get(
                    PhotoAlbumViewModel::class.java
                )

        viewModel.getPhotoAlbum()
        /*
        viewModel.photoAlbums.observe(this, Observer {
            textView2.text = it.toString()
        })*/
    }
}
