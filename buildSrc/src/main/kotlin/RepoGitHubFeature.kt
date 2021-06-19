object RepoGitHubFeature {
    val main = listOf(
        Android.APP_COMPAT,
        Android.CONSTRAINT_LAYOUT,
        Android.KTX_CODE,
        Android.MATERIAL_DESIGN,
        Android.RECYCLER_VIEW,
        Android.LIFECYCLE_EXTENSIONS,
        Android.LIFECYCLE_RUNTIME,
        Android.LIFECYCLE_VIEW_MODEL,
        Kotlin.KOTLIN_STBLIB,
        Kotlin.COROUTINES_ANDROID,
        Koin.KOIN_ANDROID,
        Koin.KON_ANDROID_VIEW_MODEL,
        Kotlin.KOTLIN_KTX
    )

    val unitTest = listOf(
        Test.JUNIT_TEST,
        Test.MOCKITO_CORE,
        Test.MOCKITO_KOTLIN,
        Test.COROUTINE_TEST
    )

    val interfaceTest = listOf(
        Test.JUNIT_EXT_TEXT,
        Test.ESPRESSO
    )
}