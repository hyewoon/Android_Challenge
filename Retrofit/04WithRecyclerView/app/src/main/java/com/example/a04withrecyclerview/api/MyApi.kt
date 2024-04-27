package com.example.a04withrecyclerview.api

import com.example.a04withrecyclerview.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {
    //첫번째 값만 가져옴
    @GET("posts/1")
    suspend fun getPost1() : Post

    @GET("posts/{number}")
    suspend fun getPostNumber(
        @Path("number") number : Int
    ) : Post

    //전체 리스트 가져옴
    @GET("posts")
    suspend fun getPostAll() : List<Post>

}