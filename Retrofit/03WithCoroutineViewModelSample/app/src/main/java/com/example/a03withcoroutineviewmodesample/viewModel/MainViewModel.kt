package com.example.a03withcoroutineviewmodesample.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a03withcoroutineviewmodesample.api.MyApi
import com.example.a03withcoroutineviewmodesample.api.RetrofitInstance
import com.example.a03withcoroutineviewmodesample.model.Post
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _mutableWord1 =  MutableLiveData<String>()
    val liveWord1 : LiveData<String>
        get() = _mutableWord1

    private val _mutableWord2 =  MutableLiveData<String>()
    val liveWord2 : LiveData<String>
        get() = _mutableWord2

    //리사이클러뷰로 보여줄 라이브데이터
    private val _mutableWordList = MutableLiveData<List<Post>>()
    val liveWordList : LiveData<List<Post>>
        get() = _mutableWordList


    val retrofitInstance = RetrofitInstance.getInstance().create(MyApi::class.java)

    fun getPost() = viewModelScope.launch {

        val post = retrofitInstance.getPost1()
        Log.d("MainViewModel", post.toString())
        _mutableWord1.value = post.title
    }

    fun getPostNumber(number: Int)  = viewModelScope.launch {
        val getPostNumber = retrofitInstance.getPostNumber(number)
        Log.d("MainViewModel", getPostNumber.toString())
        _mutableWord2.value = getPostNumber.title
    }

    fun getPostAll() = viewModelScope.launch {
        val getPostAll = retrofitInstance.getPostAll()
        Log.d("getPostAll", getPostAll.toString())
        _mutableWordList.value = getPostAll
    }



}