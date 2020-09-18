package com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tos.androidlivedataviewmodel.R
import com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.base.ViewModelFactory
import com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.main.adapter.PhotoAlbumAdapter
import com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.main.viewmodel.PhotoAlbumViewModel
import com.tos.myapplication.data.api.ApiHelper
import com.tos.myapplication.data.api.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_photo_album.*

class PhotoAlbumActivity : AppCompatActivity() {

    private lateinit var viewModel: PhotoAlbumViewModel
    private lateinit var adapter: PhotoAlbumAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_album)

        viewModel =
            ViewModelProvider(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))
                .get(
                    PhotoAlbumViewModel::class.java
                )

        viewModel.getPhotoAlbum()

//        recyclerView.layoutManager = LinearLayoutManager(this)
/*        viewModel.photoAlbums.observe(this, Observer {
//            adapter = PhotoAlbumAdapter(it)
//            recyclerView.adapter = adapter
        })*/
    }
}
