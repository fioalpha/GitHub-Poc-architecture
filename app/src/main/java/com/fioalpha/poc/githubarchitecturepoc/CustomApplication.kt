package com.fioalpha.poc.githubarchitecturepoc

import android.app.Application
import com.fioalpha.poc.data.di.dataModuleDi
import com.fioalpha.poc.domain.di.domainModuleDi
import com.fioalpha.poc.repo.di.repoModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.qualifier.named
import org.koin.dsl.module

class CustomApplication: Application() {

    val applicationModule = module {
        single(qualifier = named("URL")) { "https://api.github.com/" }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@CustomApplication)
            modules(applicationModule, repoModule, dataModuleDi, domainModuleDi)
        }
    }
}