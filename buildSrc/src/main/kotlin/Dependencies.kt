object Android {
    val KTX_CODE = "androidx.core:core-ktx:${Versions.KTX_CORE_VERSION}"
    val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    val MATERIAL_DESIGN = "com.google.android.material:material:${Versions.MATERIAL_DESIGN}"
    val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"
    val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_EXTENSIONS}"
    val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_RUNTIME}"
    val LIFECYCLE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VIEWMODEL}"
    val PICASSO = "implementation 'com.squareup.picasso:picasso:${Versions.PICASSO}"
}


object Kotlin {
    val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE_CORE}"
    val KOTLIN_STBLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_STBLIB}"
    val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_ANDROID}"

}

object Test {
    val JUNIT_TEST = "junit:junit:${Versions.JUNIT_TEST}"
    val JUNIT_EXT_TEXT = "androidx.test.ext:junit:${Versions.JUNIT_EXT_TEXT}"
    val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    val MOCKITO_CORE = "org.mockito:mockito-core:${Versions.MOCKITO_CORE}"
    val MOCKITO_KOTLIN = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO_KOTLIN}"
    val COROUTINE_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINE_TEST}"
}