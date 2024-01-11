package com.hussein.moko

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform