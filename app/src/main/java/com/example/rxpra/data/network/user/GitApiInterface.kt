package com.example.rxpra.data.network.user

import com.example.rxpra.dto.UserResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitApiInterface {
    @GET("repos/{name}/{projectName}")
    fun getUser(
        @Path("name") name: String,
        @Path("projectName") projectName: String
    ): Single<Response<UserResponse>>

}