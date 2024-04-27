package com.example.a05codelab.api

import com.example.a05codelab.model.Plant
import retrofit2.http.GET

interface MyApi {
    //인터페이스니까 추상메소드만 가능

    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlants() : List<Plant>
}