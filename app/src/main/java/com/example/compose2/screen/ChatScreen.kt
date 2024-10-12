package com.example.compose2.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose2.ui.theme.Compose2Theme
import com.example.compose2.ui.theme.darkGreen

@Composable
fun Chat() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Chat",
            color = darkGreen
        )
    }
}

@Preview
@Composable
private fun ChatPrev(showBackground: Boolean = true) {
    Compose2Theme {
        Chat()
    }
}