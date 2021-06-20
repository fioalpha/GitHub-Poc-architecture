object DataModule {
    val main = listOf(
        Retrofit.LOGGING_INTERCEPTOR,
        Retrofit.RETROFIT,
        Retrofit.RETROFIT_CONVERTER,
        Android.GSON,
        Kotlin.KOTLIN_STBLIB,
        Koin.KOIN_ANDROID
    )
}