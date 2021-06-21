plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(AndroidVersion.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidVersion.BUILD_TOOLS_VERSION)

    defaultConfig {
        applicationId = "com.fioalpha.poc.githubarchitecturepoc"
        minSdkVersion(AndroidVersion.MIN_SDK_VERSION)
        targetSdkVersion(AndroidVersion.TARGET_SDK_VERSION)
        versionCode = AndroidVersion.VERSION_CODE
        versionName = AndroidVersion.VERSION_NAME

        testInstrumentationRunner = "com.fioalpha.poc.githubarchitecturepoc.AppTestRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

dependencies {
    AppModule.main.forEach { implementation(it) }
    AppModule.unitTest.forEach { testImplementation(it) }
    AppModule.interfaceTest.forEach { androidTestImplementation(it) }
    implementation(project(":repo"))
    implementation(project(":component"))
    implementation(project( ":domain"))
    implementation(project(":infra:data"))
}
