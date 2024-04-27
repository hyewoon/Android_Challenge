package com.example.a02withcoroutine

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondViewModel : ViewModel() {

    //이럴경우 viewModel을 빠져나와도 계속 작업이 실행된다.

    fun a(){
        CoroutineScope(Dispatchers.IO).launch {
            for(i in 1..20){
                delay(1000)
                Log.d("SecondViewModel A : ", i.toString())
            }
        }
    }

    fun b(){
       viewModelScope.launch {
           for(i in 1..20){
               delay(1000)
               Log.d("SecondViewModel ViewModelScope: ", i.toString())
           }
       }
    }
}