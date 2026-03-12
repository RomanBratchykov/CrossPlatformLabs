package ua.edu.chnu.kkn.beginningkotlinmultiplatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}