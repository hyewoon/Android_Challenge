package com.example.a04withrecyclerview.viewModel

import android.app.assist.AssistStructure.ViewNode
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a04withrecyclerview.api.MyApi
import com.example.a04withrecyclerview.api.RetrofitInstance
import com.example.a04withrecyclerview.model.Post
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

    private val _mutableWord = MutableLiveData<String>()
    val liveWord : LiveData<String>
        get() = _mutableWord

    private val _mutableWordList = MutableLiveData<List<Post>>()
    val liveWordList : LiveData<List<Post>>

        get() =_mutableWordList

 //레트로핏 연결하기
    val retrofitInstance = RetrofitInstance.getInstance().create(MyApi::class.java)

    fun getPostAll() = viewModelScope.launch {
        Log.d("MyViewModel", retrofitInstance.getPostAll().toString())
       val getAll  =  retrofitInstance.getPostAll()
        _mutableWordList.value = getAll
    }




}