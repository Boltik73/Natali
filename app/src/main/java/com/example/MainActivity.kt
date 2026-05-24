package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui.ReceiveScreen
import com.example.ui.SendScreen
import com.example.ui.WalletScreen
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        androidx.compose.material3.Surface(
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            color = androidx.compose.material3.MaterialTheme.colorScheme.background
        ) {
          val navController = rememberNavController()
        
          NavHost(navController = navController, startDestination = "wallet") {
            composable("wallet") {
              WalletScreen(
                onSendClick = { navController.navigate("send") },
                onReceiveClick = { navController.navigate("receive") }
              )
            }
            composable("send") {
              SendScreen(onBack = { navController.popBackStack() })
            }
            composable("receive") {
              ReceiveScreen(onBack = { navController.popBackStack() })
            }
          }
        }
      }
    }
  }
}

