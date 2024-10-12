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
fun Status() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Status",
            color = darkGreen
        )
    }
}

@Preview
@Composable
private fun StatusPrev(showBackground: Boolean = true) {
    Compose2Theme {
        Status()
    }
}