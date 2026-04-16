package ua.edu.chnu.kkn.beginningkotlinmultiplatform

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import ua.edu.chnu.kkn.beginningkotlinmultiplatform.ui.shared_mobile.main.MainScreen

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        MainScreen()
    }
}