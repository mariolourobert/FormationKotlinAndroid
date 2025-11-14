plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.mariorobert.formationkotlinchat.data"
    compileSdk = 36

    defaultConfig {
        minSdk = 28
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.coroutines)

    ksp(libs.room.ksp)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)

    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlinx)
    implementation(libs.kotlinx.serialization.json)
}