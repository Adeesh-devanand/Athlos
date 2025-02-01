package org.athlos.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform