buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        val nav_version = "2.3.5"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
        classpath("com.android.tools.build:gradle:7.1.0-beta04")
        classpath("com.google.gms:google-services:4.3.3")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}