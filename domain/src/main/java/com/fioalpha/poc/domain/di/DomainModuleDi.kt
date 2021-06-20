package com.fioalpha.poc.domain.di

import com.fioalpha.poc.domain.model.FetchRepoGitHubUseCase
import com.fioalpha.poc.domain.model.FetchRepoGitHubUseCaseImpl
import org.koin.dsl.module

val domainModuleDi = module {
    single<FetchRepoGitHubUseCase> { FetchRepoGitHubUseCaseImpl(repository = get()) }
}