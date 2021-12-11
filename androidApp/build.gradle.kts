plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.castprogramms.bonchrestaurant.android"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        viewBinding = true
    }
}
dependencies {
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    val koin_version = "3.1.4"

    implementation(project(":shared"))
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("io.insert-koin:koin-android:$koin_version")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("androidx.navigation:navigation-fragment:2.3.5")
    implementation("com.google.firebase:firebase-core:20.0.1")
    implementation("com.google.firebase:firebase-firestore:24.0.0")
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
}
