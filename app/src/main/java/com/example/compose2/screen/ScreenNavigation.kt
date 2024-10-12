package com.example.compose2.screen

sealed class ScreenNavigation(val screen: String){
    data object CallScreen : ScreenNavigation("call")
    data object ChatScreen : ScreenNavigation("chat")
    data object StatusScreen : ScreenNavigation("status")
}