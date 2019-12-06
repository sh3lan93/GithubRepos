import BuildConfiguration.BASE_URL
import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")

}

//load the secrets file
val secretsPropertiesFile = rootProject.file("secrets.properties")
val secretProperties = Properties()
secretProperties.load(FileInputStream(secretsPropertiesFile))

android {
    compileSdkVersion(Versioning.COMPILE_SDK_VERSION)
    defaultConfig {
        applicationId = "com.shalan.githubrepos"
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
        // for all build types add the client id
        all {
            addBuildConfigField(com.android.builder.internal.ClassFieldImpl("String", "CLIENT_ID", secretProperties.getProperty("CLIENT_ID")))
        }
    }
    flavorDimensions("type")
    productFlavors {
        create("staging"){
            applicationIdSuffix = ".staging"
            setDimension("type")
            addBuildConfigField(com.android.builder.internal.ClassFieldImpl("String", "BASE_URL", BASE_URL))
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Dependencies.KOTLIN_VERSION}")
    implementation("androidx.appcompat:appcompat:${Dependencies.APP_COMPACT}")
    implementation("androidx.core:core-ktx:${Dependencies.KTX}")
    implementation("androidx.constraintlayout:constraintlayout:${Dependencies.CONSTRAINT_LAYOUT}")
    implementation("androidx.legacy:legacy-support-v4:${Dependencies.LEGACY_SUPPORT}")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
    implementation("com.google.firebase:firebase-analytics:${Dependencies.FIREBASE_ANALYTICS}")
    implementation("com.android.support:customtabs:28.0.0")
}

apply {
    plugin("com.google.gms.google-services")
}
