package com.fioalpha.poc.repo.presentation.utils

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessRecyclerScrollListener protected constructor(
    private var layoutManager: LinearLayoutManager
): RecyclerView.OnScrollListener() {
    private var currentPage = 1
    private val endlessScrollHandler = EndlessScrollHandler()
    private var isCanScroll = false

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy <= 0) return
        isCanScroll = endlessScrollHandler.handler(
            recyclerView.childCount,
            layoutManager.itemCount,
            layoutManager.findFirstVisibleItemPosition()
        )

        if (isCanScroll.not()) return
        onLoadMore(currentPage)
        currentPage ++
    }


    protected abstract fun onLoadMore(currentPage: Int)

    class EndlessScrollHandler {

        private var previousTotal = 0
        private val thresholdVisible = 5
        private var canLoader = true

        fun handler(visibleCount: Int, totalItemCount: Int, firstItemVisible: Int): Boolean {
            if (canLoader && totalItemCount > previousTotal) {
                previousTotal = totalItemCount
                canLoader = false
            }
            return isCanScroll(visibleCount, totalItemCount, firstItemVisible)
        }

        private fun isCanScroll(visibleCount: Int, totalItemCount: Int, firstItemVisible: Int): Boolean{
            return if (!canLoader && totalItemCount - visibleCount <= firstItemVisible + thresholdVisible){
                canLoader = true
                true
            } else {
                false
            }
        }
    }
}
