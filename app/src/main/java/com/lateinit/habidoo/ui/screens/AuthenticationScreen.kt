package com.lateinit.habidoo.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lateinit.habidoo.R
import com.lateinit.habidoo.auth.data.SignInState
import com.lateinit.habidoo.ui.theme.HabidooTheme
import com.lateinit.habidoo.ui.theme.HabidooYellow

@Composable
fun AuthenticationScreen(
    state: SignInState,
    innerPadding: PaddingValues,
    onSignInClick: () -> Unit,
) {
    val context = LocalContext.current

    // Error handling
    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    // UI
    val largeRadialGradient = object : ShaderBrush() {
        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            return RadialGradientShader(
                colors = listOf(Color.White, HabidooYellow),
                center = size.center,
                radius = biggerDimension / 2f,
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(largeRadialGradient)
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.habidoo_logo),
            contentDescription = "Habidoo!!",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .shadow(
                    elevation = 32.dp,
                    shape = CircleShape,
                )
        )
        Spacer(modifier = Modifier.height(height = 16.dp))
        Text(
            text = "Welcome to Habidoo!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(height = 4.dp))
        Text(text = "Please login with your account")
        Spacer(modifier = Modifier.height(height = 32.dp))
        Button(
            onClick = onSignInClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.google_logo),
                contentDescription = "Google",
                modifier = Modifier.size(32.dp)
            )
            Text(text = "Sign in with Google", modifier = Modifier.padding(6.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthenticationScreenPreview() {
    HabidooTheme {
        AuthenticationScreen(SignInState(), PaddingValues(0.dp), { })
    }
}
