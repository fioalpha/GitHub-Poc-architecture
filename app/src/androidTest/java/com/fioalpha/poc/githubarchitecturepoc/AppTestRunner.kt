package com.fioalpha.poc.githubarchitecturepoc

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner
import io.appflate.restmock.RESTMockServerStarter
import io.appflate.restmock.android.AndroidAssetsFileParser
import io.appflate.restmock.android.AndroidLogger

class AppTestRunner: AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)
        RESTMockServerStarter.startSync(
            AndroidAssetsFileParser(context),
            AndroidLogger(),
        )
    }

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        val app = ApplicationMock::class.java.canonicalName
        return super.newApplication(cl, app, context)
    }

}