object AppModule {
    val main = listOf(
        Android.APP_COMPAT,
        Android.CONSTRAINT_LAYOUT,
        Android.KTX_CODE,
        Android.MATERIAL_DESIGN,
        Kotlin.KOTLIN_STBLIB,
        Koin.KOIN_ANDROID,
        Koin.KON_ANDROID_VIEW_MODEL,
        Kotlin.COROUTINES_ANDROID,
        Kotlin.KOTLIN_KTX
    )

    val unitTest = listOf(
        Test.JUNIT_TEST
    )

    val interfaceTest = listOf(
        Test.JUNIT_EXT_TEXT,
        Test.ESPRESSO
    )
}