package com.example.restexample
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("posts/1")
    suspend fun fetchPost(): Response<MyPost>
}
        data class MyPost(
        val title:String,
        val body:String,
)
