package com.fioalpha.poc.data.di

import com.fioalpha.poc.data.repository.DataRepository
import com.fioalpha.poc.data.retrofit.OkHttpClient
import com.fioalpha.poc.data.retrofit.RetrofitService
import com.fioalpha.poc.data.service.Service
import com.fioalpha.poc.domain.Repository
import org.koin.dsl.module

val dataModuleDi = module {
    single<Service> {
        RetrofitService.createRetrofit(
            client = OkHttpClient.create()
        ).create(Service::class.java)
    }

    single<Repository> {
        DataRepository(service = get())
    }
}