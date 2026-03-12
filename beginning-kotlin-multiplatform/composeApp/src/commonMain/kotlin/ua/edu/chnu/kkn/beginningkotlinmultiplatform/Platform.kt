package ua.edu.chnu.kkn.beginningkotlinmultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform