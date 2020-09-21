package com.tos.androidlivedataviewmodel.testingPart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.base.ViewModelFactory
import com.tos.androidlivedataviewmodel.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel =
            ViewModelProvider(this, ViewModelFactory()).get(MainActivityViewModel::class.java)
        textViewSecond.text = viewModel.counter.toString()
        btnAdd.setOnClickListener {
            viewModel.addValue()
            textViewSecond.text = viewModel.counter.toString()
        }


        viewModel.seconds().observe(this, Observer {
            tvTimer.text = it.toString()
        })
        btnStart.setOnClickListener {
            if (edTimer.text.toString().isEmpty() || edTimer.text.toString().length < 4) {
                Toast.makeText(this, "Please Enter a Valid Number", Toast.LENGTH_LONG).show()
            } else {
                viewModel.userInoutValue.value = edTimer.text.toString().toLong()
                viewModel.startTimer()

            }
        }

        btnStop.setOnClickListener { viewModel.cancelTimer() }

        viewModel.timerFinished.observe(this, Observer {
            if (it) {
                Toast.makeText(this, "Timer Finished", Toast.LENGTH_LONG).show()
            }
        })

        thread {
            Thread.sleep(1000)
        }
    }
}
