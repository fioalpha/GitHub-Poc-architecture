package com.fioalpha.poc.repo.di

import com.fioalpha.poc.repo.presentation.RepoGitHubViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@OptIn(InternalCoroutinesApi::class)
val repoModule = module {
    viewModel { RepoGitHubViewModel(get()) }
}