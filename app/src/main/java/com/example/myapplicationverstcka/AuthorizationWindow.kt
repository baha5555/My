package com.example.myapplicationverstcka

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Main() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(115.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_logo_gram_black),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(102.dp))
        var text by remember { mutableStateOf("login") }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 36.dp, end = 36.dp),
            label = { "логин" },
            value = text,
            onValueChange = { text = it },
        )
        var text1 by remember { mutableStateOf("password") }

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 36.dp, end = 36.dp),
            value = text1,
            onValueChange = { text1 = it },
            label = { "пароль" },

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
            modifier = Modifier.fillMaxWidth(0.8f)
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
        Spacer(modifier = Modifier.height(156.dp))
        Row(modifier = Modifier.padding(start = 52.dp, bottom = 39.dp, end = 52.dp)) {
            Text(
                text = "Не зарегистрированы?",
                modifier = Modifier,
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,

                )
            Text(
                text = "Регистрация",
                modifier = Modifier.padding(start = 5.dp),
                fontSize = 15.sp,
                textDecoration = TextDecoration.Underline,
                color = Color.Blue,
                fontFamily = FontFamily.SansSerif,


                )
        }

    }
}
