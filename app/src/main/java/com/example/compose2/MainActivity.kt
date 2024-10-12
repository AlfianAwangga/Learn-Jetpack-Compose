package com.example.compose2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelStore
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose2.component.BottomNavBar
import com.example.compose2.component.HomeAppBar
import com.example.compose2.screen.Call
import com.example.compose2.screen.Camera
import com.example.compose2.screen.Chat
import com.example.compose2.screen.ScreenNavigation
import com.example.compose2.screen.Status
import com.example.compose2.screen.UINavigation
import com.example.compose2.ui.theme.Compose2Theme
import com.example.compose2.ui.theme.darkGreen
import com.example.compose2.ui.theme.green

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            Compose2Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    navigation()
                }
            }
        }
    }

    @Composable
    fun navigation() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = UINavigation.Home.screen,
            enterTransition = {
                slideInHorizontally{ it*1 }
            }
        ) {
            composable(UINavigation.Home.screen) {
                HomeUI(navController)
            }
            composable(UINavigation.Kamera.screen) {
                Camera(navController)
            }
        }
    }

    @Composable
    fun HomeUI(navController: NavHostController) {
        val navScreenController = rememberNavController()
        Scaffold(
            topBar = {
                HomeAppBar(navController)
            },
            content = {
                NavHost(
                    navController = navScreenController,
                    startDestination = ScreenNavigation.ChatScreen.screen,
                    modifier = Modifier.padding(it)
                ) {
                    composable(ScreenNavigation.ChatScreen.screen) { Chat() }
                    composable(ScreenNavigation.StatusScreen.screen) { Status() }
                    composable(ScreenNavigation.CallScreen.screen) { Call() }
                }
            },
            bottomBar = {
                BottomNavBar(navScreenController)
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    containerColor = darkGreen,
                    contentColor = Color.White
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = "FAB"
                    )
                }
            }
        )
    }

    @Preview
    @Composable
    private fun HomeUIPrev() {
        Compose2Theme {
            HomeUI(rememberNavController())
        }
    }
}
