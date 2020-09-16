package com.tos.androidlivedataviewmodel.testingCode

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *Created by tarikul on 14/9/20
 */

class MainActivityViewModel : ViewModel() {
    var counter: Int = 0;
    var timerFinished = MutableLiveData<Boolean>()
    var userInoutValue = MutableLiveData<Long>()
    fun addValue() {
        counter++
    }

    lateinit var timer: CountDownTimer
    var second = MutableLiveData<Int>()

    fun seconds(): LiveData<Int> {
        return second
    }

    fun startTimer() {
        timer = object : CountDownTimer(userInoutValue.value!!, 1000) {
            override fun onFinish() {
                timerFinished.value = true
            }

            override fun onTick(p0: Long) {
                val timeLeft = p0 / 1000
                second.value = timeLeft.toInt()
            }

        }.start()
    }

    fun cancelTimer() {
        timer.cancel()
    }
}