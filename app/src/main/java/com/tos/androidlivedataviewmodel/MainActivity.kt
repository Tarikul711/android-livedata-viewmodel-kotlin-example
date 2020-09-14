package com.tos.androidlivedataviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.base.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewModel =
            ViewModelProvider(this, ViewModelFactory()).get(MainActivityViewModel::class.java)
        textView.text = "0"
        btnAdd.setOnClickListener {

        }
    }
}
