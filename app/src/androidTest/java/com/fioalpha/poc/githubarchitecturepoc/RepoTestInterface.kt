package com.fioalpha.poc.githubarchitecturepoc

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.fioalpha.poc.githubarchitecturepoc.utils.RecyclerViewMatcher
import com.fioalpha.poc.repo.presentation.MainActivity
import io.appflate.restmock.RESTMockServer
import io.appflate.restmock.utils.RequestMatchers
import kotlinx.coroutines.InternalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class RepoTestInterface {

    private val mockRequest = javaClass.classLoader
        .getResource("GitRepoMock.json")
        .readText()

    @OptIn(InternalCoroutinesApi::class)
    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java, true, false)

    private val matcherRequest =  RequestMatchers.pathContains("search/repositories?q=language:kotlin&sort=stars&page=1")

    @Test
    fun testLoaderPage() {
        RESTMockServer.whenGET(matcherRequest).thenReturnString(200, mockRequest)
        Thread.sleep(300)
        rule.launchActivity(null)

        onView(RecyclerViewMatcher(R.id.repo_recycler).atPositionOnView(0, R.id.repo_name_user))
            .check(matches(withText("android")))
    }
}


