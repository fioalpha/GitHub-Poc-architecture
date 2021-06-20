package com.fioalpha.poc.repo.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.fioalpha.poc.component.get

import com.fioalpha.poc.repo.databinding.ActivityRepoMainBinding
import com.fioalpha.poc.repo.databinding.RepoItemBinding
import com.fioalpha.poc.repo.presentation.model.RepoGithub
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

@InternalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private val viewBinding by viewBinding(ActivityRepoMainBinding::inflate)
    private val repoGitHubAdapter: RepoGitHubAdapter by lazy { RepoGitHubAdapter() }

    private val viewModel: RepoGitHubViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        with(viewBinding.repoRecycler) {
            this.adapter = repoGitHubAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL))
        }

        viewModel.run {
            lifecycleScope.launch {
                bind().collect {
                    handleState(it)
                }
            }
        }
        viewBinding.repoErrorComponent.setTryAgain { loaderData() }
    }

    override fun onStart() {
        super.onStart()
        loaderData()
    }

    private fun loaderData() {
        viewModel.handle(RepoGitHubInteraction.LoaderItems)
    }

    private fun handleState(state: RepoGitHubState) {
        when(state) {
            is RepoGitHubState.Error -> {
                viewBinding.repoErrorComponent.visibility = View.VISIBLE
                viewBinding.repoSwipeRefresh.isRefreshing = false
            }
            RepoGitHubState.Idle -> { }
            RepoGitHubState.Loader -> {
                viewBinding.repoErrorComponent.visibility = View.GONE
                viewBinding.repoSwipeRefresh.isRefreshing = true
            }
            is RepoGitHubState.Result -> {
                viewBinding.repoErrorComponent.visibility = View.GONE
                viewBinding.repoSwipeRefresh.isRefreshing = false
                repoGitHubAdapter.updateData(state.data)
            }
        }
    }

}

class RepoGitHubAdapter: RecyclerView.Adapter<RepoGitHubAdapter.RepoGitHubViewHolder>() {

    private val items: MutableList<RepoGithub> = mutableListOf()

    class RepoGitHubViewHolder(binding: RepoItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoGitHubViewHolder {
        return RepoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .run {
                RepoGitHubViewHolder(this)
            }
    }

    override fun onBindViewHolder(holder: RepoGitHubViewHolder, position: Int) {
        with(RepoItemBinding.bind(holder.itemView)) {
            val data = items[position]
            repoImageUser.get(data.imagePath)
            repoFork.text = data.forks.toString()
            repoName.text = data.repoName
            repoNameUser.text = data.nameUser
            repoStar.text = data.stars.toString()
        }
    }

    override fun getItemCount(): Int = items.count()

    fun updateData(data: List<RepoGithub>) {
        items.addAll(data)
        notifyItemInserted(data.lastIndex)
    }
}

inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline binder: (LayoutInflater) -> T
) = lazy(LazyThreadSafetyMode.NONE) { binder.invoke(layoutInflater) }