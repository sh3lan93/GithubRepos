// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath( "com.android.tools.build:gradle:3.5.2")
        classpath( "org.jetbrains.kotlin:kotlin-gradle-plugin:${Dependencies.KOTLIN_VERSION}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}

tasks.register("clean").configure {
    delete("build")
}
