plugins {
    id("com.android.library")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.jhon.componentes"
    compileSdk = Versions.compileSdk

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
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree("libs") { include(listOf("*.jar")) })
    //android
    implementation(Dependencias.AndroidLibraries.coreKtx)
    implementation(Dependencias.AndroidLibraries.appCompat)
    implementation(Dependencias.AndroidLibraries.constraintlayout)
    implementation("io.insert-koin:koin-android-compat:3.2.2")
    //librerias
    implementation(Dependencias.Libraries.materialDesign)
    implementation(Dependencias.Libraries.lottie)

    //test
    implementation(Dependencias.TestLibraries.jUnit)
    implementation(Dependencias.TestLibraries.androidJUnit)
    implementation(Dependencias.TestLibraries.espresso)
}