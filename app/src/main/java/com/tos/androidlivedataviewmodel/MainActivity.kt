package com.tos.androidlivedataviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.base.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel =
            ViewModelProvider(this, ViewModelFactory()).get(MainActivityViewModel::class.java)
        textView.text = viewModel.counter.toString()
        btnAdd.setOnClickListener {
            viewModel.addValue()
            textView.text = viewModel.counter.toString()
        }


        viewModel.seconds().observe(this, Observer {
            tvTimer.text = it.toString()
        })
        btnStart.setOnClickListener {
            edTimer.text.toString()
            viewModel.startTimer()
        }

        btnStop.setOnClickListener { viewModel.cancelTimer() }

        viewModel.timerFinished.observe(this, Observer {
            if (it) {
                Toast.makeText(this, "Timer Finished", Toast.LENGTH_LONG)
            }
        })
    }
}
