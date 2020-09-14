package com.tos.androidlivedataviewmodel

import androidx.lifecycle.ViewModel

/**
 *Created by tarikul on 14/9/20
 */

class MainActivityViewModel: ViewModel() {
    var counter: Int = 0;

    fun addValue() {
        counter++
    }
}