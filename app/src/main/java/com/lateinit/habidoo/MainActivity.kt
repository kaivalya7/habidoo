package com.lateinit.habidoo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.lateinit.habidoo.navigation.LocalNavController
import com.lateinit.habidoo.navigation.NavigationStack
import com.lateinit.habidoo.ui.theme.HabidooTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            CompositionLocalProvider(LocalNavController provides navController) {
                HabidooTheme {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .systemBarsPadding()  // Apply padding once here
                    ) {
                        NavigationStack()
                    }
                }
            }
        }
    }
}
