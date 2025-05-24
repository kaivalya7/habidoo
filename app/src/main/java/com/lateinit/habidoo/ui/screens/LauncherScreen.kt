package com.lateinit.habidoo.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lateinit.habidoo.navigation.LocalNavController
import com.lateinit.habidoo.navigation.ScreenRouteData
import com.lateinit.habidoo.ui.theme.HabidooTheme
import kotlinx.coroutines.delay

/**
 * LauncherScreen is the initial screen of the Habidoo app.
 * It serves as the entry point for users, providing a placeholder like loading UI while
 * determining which screen to display next based on the user's state.
 */
@Composable
fun LauncherScreen() {

    // TODO: Implement logic to determine the next screen based on user state
    HabidooTheme {
        val navController = LocalNavController.current

        LaunchedEffect(Unit) {
            delay(5000)
            navController.navigate(ScreenRouteData.Dashboard.route)
        }
        LauncherScreenContent()
    }
}

@Composable
fun LauncherScreenContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(72.dp),
            strokeWidth = 5.dp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
fun LauncherScreenContentPreview(modifier: Modifier = Modifier) {
    HabidooTheme {
        LauncherScreenContent(modifier = modifier)
    }
}
