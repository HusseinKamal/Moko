# Moko
This is Kotlin Multiplatform app with Shared Resources with MOKO 

Dependencies Gradles

id("dev.icerock.mobile.multiplatform-resources")


listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            export("dev.icerock.moko:resources:0.23.0")
            export("dev.icerock.moko:graphics:0.9.0")
        }
    }


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
multiplatformResources {
    multiplatformResourcesPackage = "com.hussein.moko"
    multiplatformResourcesClassName = "SharedRes"
}



buildscript{
    dependencies {
        classpath ("dev.icerock.moko:resources-generator:0.23.0")
    }
}



