object DomainModule {

    val main = listOf(
        Kotlin.KOTLIN_STBLIB,
        Kotlin.COROUTINES_CORE,
        Kotlin.KOTLIN_CORE
    )

    val unitTest = listOf(
        Test.JUNIT_TEST,
        Test.MOCKITO_CORE,
        Test.MOCKITO_KOTLIN
    )

    val interfaceTest = listOf(
        Test.JUNIT_EXT_TEXT,
        Test.ESPRESSO
    )
}