/**
 * Created by Jhon Solis on 04/10/22.
 **/

object Dependencias {
    object Libraries {
        // Google
        const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
        // Retrofit
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        //Interceptor
        const val logginInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
        //Gson
        const val gsonConverter =  "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        //Room
        const val roomDataBaseRun = "androidx.room:room-runtime:${Versions.room}"
        const val roomDataBaseCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val roomDataBaseCoroutines = "androidx.room:room-ktx:${Versions.room}"
        //Fresco facebook
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
        // Livedata
        const val liveData ="androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveData}"

        //daggerHilt
        const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
        const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"

        // Lottie
        const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
        const val pdfViewer = "com.github.barteksc:android-pdf-viewer:${Versions.pdfViewer}"
        const val zoomLayout = "com.otaliastudios:zoomlayout:${Versions.zoomLayout}"
        const val rootBeer = "com.scottyab:rootbeer-lib:${Versions.rootBeer}"

        // Koin
        const val koinjavacompatibility = "io.insert-koin:koin-android-compat:${Versions.koin}"
        const val koinWordManager = "io.insert-koin:koin-androidx-workmanager:${Versions.koin}"
        const val koinMain = "io.insert-koin:koin-android:${Versions.koin}"

    }

    object KotlinLibraries {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val coroutinesTest =  "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object AndroidLibraries {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
        const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
        const val exifInterface = "androidx.exifinterface:exifinterface:${Versions.exifInterface}"
        const val mapsServices = "com.google.android.gms:play-services-maps:${Versions.mapsServices}"
        const val mapsUtils = "com.google.maps.android:android-maps-utils:${Versions.mapsSDK}"
        const val recycler = "androidx.recyclerview:recyclerview:${Versions.recycler}"
        const val progressStepper = "com.kofigyan.stateprogressbar:stateprogressbar:1.0.0"
        const val viewPager = "androidx.viewpager2:viewpager2:${Versions.viewPager}"
        const val encrypted = "androidx.security:security-crypto:${Versions.encrypted}"
        const val workManager =  "androidx.work:work-runtime-ktx:${Versions.workManager}"
    }

    object TestLibraries {
        const val jUnit = "junit:junit:4.13.2"
        const val androidJUnit = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
        const val mockito = "io.mockk:mockk:1.12.2"
        const val androidXcore = "androidx.arch.core:core-testing:2.1.0"
        const val jsonForJVM = "org.json:json:20140107"
    }

}