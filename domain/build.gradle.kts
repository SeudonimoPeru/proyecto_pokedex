plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")

}

android {
    namespace = "com.jhon.domain"
    compileSdk = 32

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(fileTree("libs") { include(listOf("*.jar")) })
    implementation(Dependencias.KotlinLibraries.coroutinesAndroid)
    implementation(Dependencias.KotlinLibraries.coroutinesCore)
    implementation(Dependencias.Libraries.koinMain)

    implementation(Dependencias.TestLibraries.jUnit)
    implementation(Dependencias.TestLibraries.androidJUnit)
    implementation(Dependencias.TestLibraries.espresso)
    implementation(Dependencias.TestLibraries.mockito)

}