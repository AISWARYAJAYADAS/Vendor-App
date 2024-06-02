package com.example.vendorapp.screens.signup

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vendorapp.R
import kotlinx.coroutines.launch

@Composable
fun Testt() {
    val buttonWidth = 200.dp
    val buttonHeight = 50.dp
    val buttonWidth2 = 400.dp
    val buttonHeight2 = 50.dp
    val rippleColor = Color(0xFFaf9221)
    val rippleAlpha = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp)
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    coroutineScope.launch {
                        rippleAlpha.animateTo(
                            targetValue = 0.5f,
                            animationSpec = tween(500)
                        )
                    }
                }
            },
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(buttonWidth, buttonHeight)
        ) {
            drawRoundRect(
                color = rippleColor.copy(alpha = rippleAlpha.value),
                size = size,
                cornerRadius = CornerRadius(25f), // Adjust the corner radius as needed
                style = Stroke(width = 4.dp.toPx())
            )
        }

        OutlinedButton(
            onClick = { /* Handle signup button click */ },
            modifier = Modifier.size(buttonWidth2, buttonHeight),
            shape = RoundedCornerShape(25.dp), // Adjust the corner radius as needed
            colors = androidx.compose.material3.ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = rippleColor
            )
        ) {
            Text(
                text = "Signup",
                fontSize = 20.sp,
                color = rippleColor
            )
        }
    }
}


@Composable
fun Test123() {
    val buttonWidth = 200.dp
    val buttonHeight = 50.dp
    val buttonWidth2 = 400.dp
    val buttonHeight2 = 50.dp
    val rippleColor = Color(0xFFaf9221)
    val rippleAlpha = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp)
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    coroutineScope.launch {
                        rippleAlpha.animateTo(
                            targetValue = 0.5f,
                            animationSpec = tween(500)
                        )
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(buttonWidth, buttonHeight)
        ) {
            drawRoundRect(
                color = rippleColor.copy(alpha = rippleAlpha.value),
                size = size,
                cornerRadius = CornerRadius(25f), // Adjust the corner radius as needed
                style = Stroke(width = 4.dp.toPx())
            )
        }

        OutlinedButton(
            onClick = { /* Handle signup button click */ },
            modifier = Modifier.size(buttonWidth2, buttonHeight),
            shape = RoundedCornerShape(25.dp), // Adjust the corner radius as needed
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = rippleColor
            )
        ) {
            Text(
                text = "Signup",
                fontSize = 20.sp,
                color = rippleColor
            )
        }
    }
}

@Composable
fun Test456() {
    val buttonWidth = 200.dp
    val buttonHeight = 50.dp
    val buttonWidth2 = 400.dp
    val buttonHeight2 = 50.dp
    val rippleColor = Color(0xFFaf9221)
    val rippleAlpha = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp)
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    coroutineScope.launch {
                        rippleAlpha.animateTo(
                            targetValue = 0.5f,
                            animationSpec = tween(500)
                        )
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(buttonWidth, buttonHeight)
        ) {
            drawRoundRect(
                color = rippleColor.copy(alpha = rippleAlpha.value),
                size = size,
                cornerRadius = CornerRadius(25f), // Adjust the corner radius as needed
                style = Stroke(width = 4.dp.toPx())
            )
        }

        OutlinedButton(
            onClick = { /* Handle signup button click */ },
            modifier = Modifier.size(buttonWidth2, buttonHeight),
            shape = RoundedCornerShape(25.dp), // Adjust the corner radius as needed
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = rippleColor
            )
        ) {
            Text(
                text = "Signup",
                fontSize = 20.sp,
                color = rippleColor
            )
        }
    }
}



@Composable
fun MedicalStoreButton(
    text: String,
    onClick: () -> Unit
) {
    val buttonWidth = 200.dp
    val buttonHeight = 50.dp
    val buttonWidth2 = 400.dp
    val buttonHeight2 = 50.dp
    val rippleColor = Color(0xFF4CAF50) // Green color for medical theme
    val rippleAlpha = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp)
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    coroutineScope.launch {
                        rippleAlpha.animateTo(
                            targetValue = 0.5f,
                            animationSpec = tween(500)
                        )
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(buttonWidth, buttonHeight)
        ) {
            drawRoundRect(
                color = rippleColor.copy(alpha = rippleAlpha.value),
                size = size,
                cornerRadius = CornerRadius(25f), // Adjust the corner radius as needed
                style = Stroke(width = 4.dp.toPx())
            )
        }

        OutlinedButton(
            onClick = onClick,
            modifier = Modifier.size(buttonWidth2, buttonHeight),
            shape = RoundedCornerShape(25.dp), // Adjust the corner radius as needed
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = rippleColor
                //contentColor = Color.Black

            )
        ) {
            Text(
                text = text,
                fontSize = 18.sp,
                color = rippleColor,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.sfpro))
            )
        }
    }
}
