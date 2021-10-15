package com.pocraft.motionscale

object Versions {
    const val compose = "1.0.4"
    const val ktlint = "0.41.0"
    const val accompanist = "0.10.0"
    const val retrofit = "2.9.0"
    const val room = "2.3.0"
    const val hilt = "2.35"
    const val lifecycleKtx = "2.4.0-alpha01"
    const val workManager = "2.5.0"
    const val emoji2 = "1.0.0-alpha01"
}

object Dep {
    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val materialIconsExtend = "androidx.compose.material:material-icons-extended:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val activity = "androidx.activity:activity-compose:1.3.0-alpha07"
        const val util = "androidx.compose.ui:ui-util:${Versions.compose}"
        const val test = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        const val navigation = "androidx.navigation:navigation-compose:2.4.0-alpha01"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha07"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha04"
        const val paging = "androidx.paging:paging-compose:1.0.0-alpha09"
    }

    object Accompanist {
        const val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
        const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
        const val glide = "com.google.accompanist:accompanist-glide:${Versions.accompanist}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object Dagger {
        const val plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
        const val kaptCompiler = "androidx.room:room-compiler:${Versions.room}"
    }

    const val kotlinxDatetime = "org.jetbrains.kotlinx:kotlinx-datetime:0.2.0"

    const val ktlint = "com.pinterest:ktlint:${Versions.ktlint}"

    const val securityCrypto = "androidx.security:security-crypto:1.1.0-alpha03"

    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"

    const val lottieCompose = "com.airbnb.android:lottie-compose:1.0.0-beta07-1"
    const val lottie = "com.airbnb.android:lottie:3.7.0"

    object WorkManager {
        const val ktx = "androidx.work:work-runtime-ktx:${Versions.workManager}"
    }

    object Emoji {
        const val emoji2 = "androidx.emoji2:emoji2:${Versions.emoji2}"
    }
}