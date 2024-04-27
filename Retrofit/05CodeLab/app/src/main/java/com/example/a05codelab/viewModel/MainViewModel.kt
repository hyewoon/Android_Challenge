package com.example.a05codelab.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a05codelab.api.MyApi
import com.example.a05codelab.api.RetrofitInstance
import com.example.a05codelab.model.Plant
import com.example.a05codelab.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.create

class MainViewModel: ViewModel() {
    //라이브데이터 적용
    val _result = MutableLiveData<List<Plant>>()
    val result : LiveData<List<Plant>>
        get() = _result

   // val retrofitInstance : MyApi = RetrofitInstance.getInstance().create(MyApi::class.java)
    val repository = Repository()

    fun getAllData() = viewModelScope.launch {
       // Log.d("MainViewModel", retrofitInstance.getAllPlants().toString())

       _result.value = repository.getAllData()

    }

}