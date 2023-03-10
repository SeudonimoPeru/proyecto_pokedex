// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version ("7.3.0") apply (false)
    id("com.android.library") version ("7.3.0") apply (false)
    id("org.jetbrains.kotlin.android") version ("1.7.10") apply (false)
}



buildscript {

    repositories{
        mavenCentral()
        google()
        jcenter()
    }

    dependencies {
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath ("com.android.tools.build:gradle:7.3.1")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.8.1")
        classpath("io.mockk:mockk:1.12.2")

    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}