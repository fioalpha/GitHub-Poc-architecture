package com.fioalpha.poc.repo.presentation

import com.fioalpha.poc.domain.model.FetchRepoGitHubUseCase
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class RepoGitHubViewModelTest {

    private val fetchUseCase: FetchRepoGitHubUseCase = mock()

    private lateinit var viewModel: RepoGitHubViewModel

    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        viewModel = RepoGitHubViewModel(fetchUseCase)
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `when called LoaderItems With success request then Return success state`() {
        runBlocking(Dispatchers.Main) {
            whenever(fetchUseCase.execute(any())).thenReturn(listOf())
            val value = viewModel.bind()
            Assert.assertTrue(value.value is RepoGitHubState.Idle)
            viewModel.handle(RepoGitHubInteraction.LoaderItems)
            Assert.assertTrue(value.value is RepoGitHubState.Result)
        }
    }

}