package com.fioalpha.poc.domain.usecase

import com.fioalpha.poc.domain.Repository
import com.fioalpha.poc.domain.model.FetchRepoGitHubUseCase
import com.fioalpha.poc.domain.model.FetchRepoGitHubUseCaseImpl
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class FetchRepoGitHubUseCaseTest {

    private val repository: Repository = mock()

    private lateinit var useCase: FetchRepoGitHubUseCase


    @Before
    fun setup() {
        useCase = FetchRepoGitHubUseCaseImpl(repository)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `when called execute With success request` () = runBlockingTest {
        whenever(repository.fetchRepoGutHub(1)).thenReturn(listOf())
        Assert.assertTrue(useCase.execute(1).isEmpty())
    }

}