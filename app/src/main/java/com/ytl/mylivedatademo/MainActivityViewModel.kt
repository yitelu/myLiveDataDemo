package com.ytl.mylivedatademo

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private lateinit var timer: CountDownTimer

    private val _seconds = MutableLiveData<Int>()
    private val _finished = MutableLiveData<Boolean>()

    fun seconds(): LiveData<Int> {
        return _seconds
    }

    fun finished(): LiveData<Boolean>{
        return _finished
    }

    fun startTimer(){
        timer = object: CountDownTimer(10000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished/1000
                _seconds.value = timeLeft.toInt()
            }

            override fun onFinish() {
                _finished.value = true
            }
        }.start()
    }

    fun stopTimer(){
        timer.cancel()
    }
}