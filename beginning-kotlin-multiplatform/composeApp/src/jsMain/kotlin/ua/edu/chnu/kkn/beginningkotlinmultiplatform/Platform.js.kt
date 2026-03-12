package ua.edu.chnu.kkn.beginningkotlinmultiplatform

class JsPlatform: Platform {
    override val name: String = "Web with Kotlin/JS"
}

actual fun getPlatform(): Platform = JsPlatform()