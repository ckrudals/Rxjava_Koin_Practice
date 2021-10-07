package com.example.rxpra.data.repository

import com.example.rxpra.data.network.user.GitApiInterface
import com.example.rxpra.data.network.user.UserRepository
import com.example.rxpra.dto.UserResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class UserRepositoryImpl (private val gitApiInterface: GitApiInterface) : UserRepository {
    override suspend fun getUser(name: String, projectName: String): Single<Response<UserResponse>> =
        gitApiInterface.getUser(name,projectName)
}

