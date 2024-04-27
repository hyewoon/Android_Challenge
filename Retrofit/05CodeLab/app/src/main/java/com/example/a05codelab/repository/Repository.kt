package com.example.a05codelab.repository

import com.example.a05codelab.api.MyApi
import com.example.a05codelab.api.RetrofitInstance

class Repository {

    //viewModel에서 했던 작업을 repository에서 실행 -> viewModel에서는 호출하여 사용한다.
    val client : MyApi = RetrofitInstance.getInstance().create(MyApi::class.java)

    suspend fun getAllData() = client.getAllPlants()
}