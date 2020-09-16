package com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tos.androidlivedataviewmodel.testingCode.testingPart.MainActivityViewModel

/**
 *Created by tarikul on 5/9/20
 */
class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel() as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}