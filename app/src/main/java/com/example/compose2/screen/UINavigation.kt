package com.example.compose2.screen

sealed class UINavigation(val screen: String) {
    data object Home : UINavigation("home")
    data object Kamera : UINavigation("kamera")
}