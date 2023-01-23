plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.jhon.pokedex"
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.jhon.pokedex"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = ConfigGradle.Release.versionCode
        versionName = ConfigGradle.Release.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        getByName("debug") {
            keyAlias = ConfigGradle.BuildTypes.Debug.keyAlias
            keyPassword = ConfigGradle.BuildTypes.Debug.password
            storeFile = file(ConfigGradle.BuildTypes.Debug.firmaFile)
            storePassword = ConfigGradle.BuildTypes.Debug.password
        }
        create("release") {
            keyAlias = ConfigGradle.BuildTypes.Release.keyAlias
            keyPassword = ConfigGradle.BuildTypes.Release.password
            storeFile = file(ConfigGradle.BuildTypes.Release.firmaFile)
            storePassword = ConfigGradle.BuildTypes.Release.password
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}


dependencies {
    implementation(fileTree("libs") { include(listOf("*.jar")) })
    //modulo
    implementation(project(mapOf("path" to ConfigGradle.Module.componentes)))
    implementation(project(mapOf("path" to ConfigGradle.Module.data)))
    implementation(project(mapOf("path" to ConfigGradle.Module.domain)))

    //android
    implementation(Dependencias.AndroidLibraries.coreKtx)

    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.0")
    implementation(Dependencias.AndroidLibraries.appCompat)
    implementation(Dependencias.AndroidLibraries.activity)
    implementation(Dependencias.AndroidLibraries.constraintlayout)
    implementation(Dependencias.AndroidLibraries.navigationUi)
    implementation(Dependencias.AndroidLibraries.navigationFragment)
    implementation(Dependencias.AndroidLibraries.legacySupport)
    //librerias
    implementation(Dependencias.Libraries.materialDesign)
    implementation(Dependencias.KotlinLibraries.kotlin)
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(Dependencias.Libraries.lottie)
    implementation(Dependencias.Libraries.koinMain)
    implementation(Dependencias.Libraries.koinjavacompatibility)
    implementation(Dependencias.Libraries.koinWordManager)
    implementation(Dependencias.Libraries.gson)

    //test
    implementation(Dependencias.TestLibraries.jUnit)
    implementation(Dependencias.TestLibraries.androidJUnit)
    implementation(Dependencias.TestLibraries.espresso)
    implementation("io.insert-koin:koin-android-compat:3.2.2")
}

