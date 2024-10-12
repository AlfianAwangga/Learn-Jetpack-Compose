package com.example.compose2.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose2.screen.ScreenNavigation
import com.example.compose2.ui.theme.Compose2Theme
import com.example.compose2.ui.theme.darkGreen

@Composable
fun BottomNavBar(navController: NavHostController) {
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    BottomAppBar(
        containerColor = Color.White,
        contentColor = darkGreen,
        tonalElevation = 8.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Email
                    navController.navigate(ScreenNavigation.ChatScreen.screen){
                        popUpTo(0)
                    }
                },
                modifier = Modifier.size(60.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Chat",
                    tint = if (selected.value == Icons.Default.Email) darkGreen else Color.Gray,
                    modifier = Modifier.size(40.dp)
                )
            }
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Refresh
                    navController.navigate(ScreenNavigation.StatusScreen.screen){
                        popUpTo(0)
                    }
                },
                modifier = Modifier.size(60.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Status",
                    tint = if (selected.value == Icons.Default.Refresh) darkGreen else Color.Gray,
                    modifier = Modifier.size(40.dp)
                )
            }
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Call
                    navController.navigate(ScreenNavigation.CallScreen.screen){
                        popUpTo(0)
                    }
                },
                modifier = Modifier.size(60.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call",
                    tint = if (selected.value == Icons.Default.Call) darkGreen else Color.Gray,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun BottomNavBarPrev(showBackground: Boolean = true) {
    Compose2Theme {
        BottomNavBar(
            navController = rememberNavController()
        )
    }
}