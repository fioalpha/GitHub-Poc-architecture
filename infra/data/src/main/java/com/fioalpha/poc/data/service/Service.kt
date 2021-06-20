package com.fioalpha.poc.data.service

import com.fioalpha.poc.data.retrofit.model.GitHubRequest
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("/search/repositories?q=language:kotlin&sort=stars")
    suspend fun fetchRepo(
        @Query("page")page: Int = 1
    ): GitHubRequest

}

