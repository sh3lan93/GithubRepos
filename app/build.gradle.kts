
plugins{
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")

}

android {
    compileSdkVersion(Versioning.COMPILE_SDK_VERSION)
    defaultConfig {
        applicationId = "com.shalan.locator"
        minSdkVersion(Versioning.MIN_SDK)
        targetSdkVersion(Versioning.COMPILE_SDK_VERSION)
        versionCode = Versioning.VERSION_CODE
        versionName = Versioning.VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Dependencies.KOTLIN_VERSION}")
    implementation("androidx.appcompat:appcompat:${Dependencies.APP_COMPACT}")
    implementation("androidx.core:core-ktx:${Dependencies.KTX}")
    implementation("androidx.constraintlayout:constraintlayout:${Dependencies.CONSTRAINT_LAYOUT}")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
