package com.fioalpha.poc.domain.di

import com.fioalpha.poc.domain.usecase.FetchRepoGitHubUseCase
import com.fioalpha.poc.domain.usecase.FetchRepoGitHubUseCaseImpl
import org.koin.dsl.module

val domainModuleDi = module {
    single<FetchRepoGitHubUseCase> { FetchRepoGitHubUseCaseImpl(repository = get()) }
}