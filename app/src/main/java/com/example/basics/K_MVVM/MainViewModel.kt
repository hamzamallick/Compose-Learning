package com.example.basics.K_MVVM

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var num = 0

    fun increaseCount() {
        num++;
    }
}