
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // needed by the local database
    id("com.google.devtools.ksp")

    // needed for the dependency injection
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.bluromatic"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bluromatic"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // needed for collectAsStateWithLifecycle()
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")

    // needed for viewModel() function
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    // needed for the dependency injection
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")

    // needed for the work manager
    implementation("androidx.work:work-runtime-ktx:2.8.1")

    // needed for Hilt with Work Manager (not used)
    // implementation("androidx.hilt:hilt-work:1.1.0")

    // needed for the WorkInfo, it gets LiveData and converts to Flow
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Work testing
    androidTestImplementation("androidx.work:work-testing:2.8.1")

}
