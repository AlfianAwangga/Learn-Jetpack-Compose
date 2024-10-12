package com.example.compose2.component

import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose2.R
import com.example.compose2.screen.UINavigation
import com.example.compose2.ui.theme.Compose2Theme
import com.example.compose2.ui.theme.darkGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(navController: NavHostController) {
    val context = LocalContext.current.applicationContext

    TopAppBar(
        title = {
            Text(text = "WA Compose")
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    Toast.makeText(context, "WhatsApp", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.whatsapp_icon),
                    contentDescription = "WA Icon"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = darkGreen,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        actions = {
            IconButton(
                onClick = {
                    navController.navigate(UINavigation.Kamera.screen)
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.camera_icon),
                    contentDescription = "Kamera Icon"
                )
            }
            IconButton(
                onClick = {
                    Toast.makeText(context, "Other", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.camera_icon),
                    contentDescription = "Kamera Icon"
                )
            }
        }
    )
}

@Preview
@Composable
private fun HomeAppBarPrev(showBackground: Boolean = true) {
    Compose2Theme {
        HomeAppBar(rememberNavController())
    }
}