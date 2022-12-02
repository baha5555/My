package com.example.myapplicationverstcka

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Main() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(90.dp))
      Image(painter = R.drawable.ic_logo_gram_black, contentDescription ="" )
        Spacer(modifier = Modifier.height(90.dp))
        var text by remember { mutableStateOf("Hello") }
        OutlinedTextField(
            value = "login",
            onValueChange = { text = it },
            label = { Text("Label") }
        )

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = "password",
            onValueChange = { text = it },
            label = { Text("Label") },

            trailingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.eye),
                    contentDescription = ""
                )
            }
        )

        Spacer(modifier = Modifier.height(11.dp))

            Text(
                color = Color(0xff848484),
                text = "Забыли Пароль?",
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth(0.65f)
            )


        Spacer(modifier = Modifier.height(58.dp))
        Button(
            modifier = Modifier
                .width(303.dp)
                .height(60.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text(
                text = "Войти",
                modifier = Modifier,
                color = Color.White
            )
        }
    }
}
