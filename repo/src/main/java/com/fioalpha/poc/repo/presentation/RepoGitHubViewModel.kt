package com.fioalpha.poc.repo.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fioalpha.poc.domain.usecase.FetchRepoGitHubUseCase
import com.fioalpha.poc.repo.presentation.model.RepoGithub
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class RepoGitHubViewModel(
    private val usecase: FetchRepoGitHubUseCase
): ViewModel() {
    private val states: MutableStateFlow<RepoGitHubState> = MutableStateFlow(RepoGitHubState.Idle)
    private val interactions = Channel<RepoGitHubInteraction>(Channel.UNLIMITED)
    private var pageCurrent = 1

    init {
        viewModelScope.launch {
            interactions.consumeAsFlow().collect {
                when (it) {
                    is RepoGitHubInteraction.LoaderItems -> fetch(pageCurrent)
                    is RepoGitHubInteraction.UpdateItem -> {
                        pageCurrent = it.page
                        fetch(pageCurrent)
                    }
                }
            }
        }
    }

    fun bind() = states.asStateFlow()

    fun handle(interaction: RepoGitHubInteraction) = viewModelScope.launch {
        interactions.send(interaction)
    }

    private suspend fun fetch(page: Int) {
        states.value = RepoGitHubState.Loader
        try {
            val result = usecase.execute(page).map {
                RepoGithub(
                    it.name,
                    it.stars,
                    it.forks,
                    it.user.name,
                    it.user.picture
                )
            }
            states.value = RepoGitHubState.Result(result)
        } catch (e: Exception){
            Log.e("ERRO", e.message?: "EROR")
            states.value = RepoGitHubState.Error("Has error")
        }
    }
}