package com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tos.androidlivedataviewmodel.R
import com.tos.androidlivedataviewmodel.testingCode.projectOne.data.model.PhotoModel
import com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.base.ViewModelFactory
import com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.main.adapter.PhotoAlbumAdapter
import com.tos.androidlivedataviewmodel.testingCode.projectOne.ui.main.viewmodel.PhotoAlbumViewModel
import com.tos.androidlivedataviewmodel.testingCode.projectOne.utils.Status
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
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PhotoAlbumAdapter(arrayListOf())
        recyclerView.adapter = adapter
        viewModel.getAllPhotos().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        recyclerView.visibility = View.VISIBLE
                        resource.data?.let { photos -> bindDataWithAdapter(photos) }
                    }
                    Status.ERROR -> {
                        progressBar.visibility = View.GONE
                        recyclerView.visibility = View.VISIBLE
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun bindDataWithAdapter(results: List<PhotoModel>) {
        adapter.apply {
            addAllAlbums(results)
            notifyDataSetChanged()
        }
    }
}
