/*
 * Copyright (c) 2021 Matthew Nelson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
import org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED
import org.gradle.api.tasks.testing.logging.TestLogEvent.STARTED

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    dependencies {
        classpath(io.matthewnelson.kotlin.components.dependencies.plugins.android.gradle)
        classpath(io.matthewnelson.kotlin.components.dependencies.plugins.kotlin.gradle)
        classpath(io.matthewnelson.kotlin.components.dependencies.plugins.mavenPublish)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {

    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    tasks.withType<Test> {
        testLogging {
            exceptionFormat = TestExceptionFormat.FULL
            events(STARTED, PASSED, SKIPPED, FAILED)
            showStandardStreams = true
        }
    }

}

plugins {
    id(pluginId.kmp.publish)
}

kmpPublish {
    setupRootProject(
        versionName = "0.4.7.11",
        //    0.4.6.9  == 00_04_06_09_00
        //    0.4.6.9a == 00_04_06_09_01
        //    0.4.6.9b == 00_04_06_09_02
        versionCode = /*00_0*/4_07_11_00,
        pomInceptionYear = 2021,
    )
}
