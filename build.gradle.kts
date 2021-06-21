buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_STBLIB}")
        classpath("com.vanniktech:gradle-android-junit-jacoco-plugin:0.16.0")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.1.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://oss.jfrog.org/libs-snapshot")
        maven("https://jitpack.io" )
    }

    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

tasks.register("clean").configure {
    delete("build")
}

apply(plugin = "com.vanniktech.android.junit.jacoco")

configure<com.vanniktech.android.junit.jacoco.JunitJacocoExtension> {
    jacocoVersion = "0.8.7"
}
