package com.fioalpha.poc.githubarchitecturepoc

import io.appflate.restmock.RESTMockServer
import org.koin.core.qualifier.named
import org.koin.dsl.module

class ApplicationMock: CustomApplication() {

    override val applicationModule = module {
        single(override = true, qualifier = named("URL")) {
            RESTMockServer.getUrl()
        }
    }
}