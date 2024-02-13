# This is Kotlin Multiplatform app with Shared Resources with MOKO

Dependencies Gradles

id("dev.icerock.mobile.multiplatform-resources")

listOf( iosX64(), iosArm64(), iosSimulatorArm64() ).forEach { it.binaries.framework { baseName = "shared" export("dev.icerock.moko:resources:0.23.0") export("dev.icerock.moko:graphics:0.9.0") } }

sourceSets {
    val commonMain by getting {
        dependencies {
            //put your multiplatform dependencies here
            api("dev.icerock.moko:resources:0.23.0")
        }
    }
    val commonTest by getting {
        dependencies {
            implementation(kotlin("test"))
        }
    }
}

multiplatformResources { multiplatformResourcesPackage = "com.hussein.moko" multiplatformResourcesClassName = "SharedRes" }

buildscript{ dependencies { classpath ("dev.icerock.moko:resources-generator:0.23.0") } }

# Add these lines to solve issue "Expected object 'MR' has no actual declaration in module <composeApp_debug> for JVM"
        getByName("androidMain").dependsOn(commonMain.get())
        getByName("jvmMain").dependsOn(commonMain.get())
        getByName("iosArm64Main").dependsOn(commonMain.get())
        getByName("iosX64Main").dependsOn(commonMain.get())
        getByName("iosSimulatorArm64Main").dependsOn(commonMain.get())
