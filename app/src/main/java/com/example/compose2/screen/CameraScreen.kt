package com.example.compose2.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose2.ui.theme.Compose2Theme
import com.example.compose2.ui.theme.darkGreen

@Composable
fun Camera(navController: NavHostController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Camera",
                color = darkGreen
            )
            Button(
                onClick = { navController.navigate(UINavigation.Home.screen) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = darkGreen
                )
            ) {
                Text(text = "Back")
            }
        }
    }
}

@Preview
@Composable
private fun CameraPrev(showBackground: Boolean = true) {
    Compose2Theme {
        Camera(rememberNavController())
    }
}