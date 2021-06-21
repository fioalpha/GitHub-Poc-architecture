package com.fioalpha.poc.repo.presentation

import com.fioalpha.poc.domain.usecase.FetchRepoGitHubUseCase
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*

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

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Ignore
    @Test()
    fun `when called LoaderItems With success request then Return success state`() {
        runBlocking {
            whenever(fetchUseCase.execute(any())).thenReturn(listOf())
            val value = viewModel.bind()
            Assert.assertTrue(value.value is RepoGitHubState.Idle)
            viewModel.handle(RepoGitHubInteraction.LoaderItems)
            Assert.assertTrue(value.value is RepoGitHubState.Result)
        }
    }

}