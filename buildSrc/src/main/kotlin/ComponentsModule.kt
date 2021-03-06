object ComponentsModule {
    val main = listOf(
        Android.APP_COMPAT,
        Android.CONSTRAINT_LAYOUT,
        Android.KTX_CODE,
        Android.MATERIAL_DESIGN,
        Kotlin.KOTLIN_STBLIB,
        Android.PICASSO
    )

    val unitTest = listOf(
        Test.JUNIT_TEST
    )

    val interfaceTest = listOf(
        Test.JUNIT_EXT_TEXT,
        Test.ESPRESSO
    )
}