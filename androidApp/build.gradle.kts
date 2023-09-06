plugins {
    id("com.android.application")
    kotlin("android")
//    id("com.google.devtools.ksp").version("1.9.0-1.0.12")
//    id("com.google.devtools.ksp").version("1.7.22-1.0.8")
}

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
    }
}

android {
    namespace = "com.example.kmmpoc.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.kmmpoc.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
    val koinComposeVersion = "3.4.1"
    val coilVersion = "2.4.0"
    val accompanistVersion = "0.28.0"
    val navVersion = "2.5.3"

    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.activity:activity-compose:1.7.2")

    implementation("io.insert-koin:koin-androidx-compose:$koinComposeVersion")
    implementation("io.coil-kt:coil-compose:$coilVersion")
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
    //noinspection GradleDependency
    implementation ("org.jetbrains.kotlin:kotlin-reflect:1.3.61")
    implementation("androidx.navigation:navigation-compose:$navVersion")
//    implementation("io.github.raamcosta.compose-destinations:animations-core:1.9.51")
//    ksp("io.github.raamcosta.compose-destinations:animations-core:1.9.51")

}
