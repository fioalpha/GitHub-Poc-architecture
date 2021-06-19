package com.fioalpha.poc.repo.di

import com.fioalpha.poc.domain.Repository
import com.fioalpha.poc.domain.model.FetchRepoGitHubUseCase
import com.fioalpha.poc.domain.model.FetchRepoGitHubUseCaseImpl
import com.fioalpha.poc.domain.model.RepoGitHub
import com.fioalpha.poc.domain.model.User
import com.fioalpha.poc.repo.presentation.RepoGitHubViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@OptIn(InternalCoroutinesApi::class)
val repoModule = module {
    single<FetchRepoGitHubUseCase> { FetchRepoGitHubUseCaseImpl(object : Repository {
        override suspend fun fetchRepoGutHub(page: Int): List<RepoGitHub> {
            delay(10000)
            return listOf(
                RepoGitHub(
                    "Test",
                    4,4,
                    User("", "sdkfhklsdf")
                )
            )
        }

    }) }
    viewModel { RepoGitHubViewModel(get()) }
}