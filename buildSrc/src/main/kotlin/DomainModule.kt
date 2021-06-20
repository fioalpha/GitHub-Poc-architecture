object DomainModule {

    val main = listOf(
        Kotlin.KOTLIN_STBLIB,
        Kotlin.COROUTINES_CORE,
        Koin.KOIN_CORE
    )

    val unitTest = listOf(
        Test.JUNIT_TEST,
        Test.MOCKITO_CORE,
        Test.MOCKITO_KOTLIN,
        Test.COROUTINE_TEST
    )

}