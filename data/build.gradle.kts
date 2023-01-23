plugins {
    id ("com.android.library")
    id("kotlin-kapt")
    id ("org.jetbrains.kotlin.android")

}

android {
    namespace = "com.jhon.data"
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
            buildConfigField("String", "BaseURL", "\"https://pokeapi.co/api/v2/\"")
        }

        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BaseURL", "\"https://pokeapi.co/api/v2/\"")
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
    implementation(project(mapOf("path" to ConfigGradle.Module.domain)))
    //android
    implementation(Dependencias.AndroidLibraries.coreKtx)
    implementation(Dependencias.AndroidLibraries.appCompat)
    implementation(Dependencias.AndroidLibraries.encrypted)


    implementation(Dependencias.Libraries.retrofit)
    implementation(Dependencias.Libraries.logginInterceptor)
    implementation(Dependencias.Libraries.gsonConverter)
    implementation(Dependencias.Libraries.koinMain)
    implementation(Dependencias.Libraries.koinjavacompatibility)

    implementation(Dependencias.Libraries.roomDataBaseRun)

    kapt(Dependencias.Libraries.roomDataBaseCompiler)
    annotationProcessor(Dependencias.Libraries.roomDataBaseCompiler)


    implementation(Dependencias.Libraries.roomDataBaseCoroutines)



    implementation(Dependencias.Libraries.koinjavacompatibility)



    //test
    implementation(Dependencias.TestLibraries.jUnit)
    implementation(Dependencias.TestLibraries.androidJUnit)
    implementation(Dependencias.TestLibraries.espresso)
    implementation(project(mapOf("path" to ConfigGradle.Module.domain)))
}

