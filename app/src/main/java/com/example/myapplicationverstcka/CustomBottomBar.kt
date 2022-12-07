package com.example.myapplicationverstcka

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

@Composable
fun CustomBottomBar(painter: ImageVector, text: String) {
    Box() {
        Column {
            Icon(tint = Color.White,imageVector = painter, contentDescription = null)
            Text(text, color = Color.White)
        }
    }
}

