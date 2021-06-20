package com.fioalpha.poc.githubarchitecturepoc

import android.app.Application
import com.fioalpha.poc.data.di.dataModuleDi
import com.fioalpha.poc.domain.di.domainModuleDi
import com.fioalpha.poc.repo.di.repoModule
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CustomApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@CustomApplication)
            modules(repoModule, dataModuleDi, domainModuleDi)
        }
    }
}