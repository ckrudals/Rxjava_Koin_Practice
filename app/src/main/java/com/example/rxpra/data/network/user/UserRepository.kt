package com.example.rxpra.data.network.user

import com.example.rxpra.dto.UserResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

interface UserRepository{
    suspend fun getUser(name:String, projectName:String) : Single<Response<UserResponse>>
}