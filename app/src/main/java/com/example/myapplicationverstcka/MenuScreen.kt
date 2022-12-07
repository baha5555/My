package com.example.myapplicationverstcka

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Menu() {
    var check by remember{ mutableStateOf(false) }
    val context = LocalContext.current
    val checkedState = remember { mutableStateOf(false) }
    val checkedState2 = remember { mutableStateOf(false) }
    val iconList = arrayOf(
        ImageVector.vectorResource(id = R.drawable.panel),
        ImageVector.vectorResource(id = R.drawable.carta),
        ImageVector.vectorResource(id = R.drawable.zakaz),
        ImageVector.vectorResource(id = R.drawable.chat),
        ImageVector.vectorResource(id = R.drawable.menu),
    )
    val counter = listOf(1, 2, 3, 4, 5);
    val textList = arrayOf(
        "Панель",
        "Карта",
        "Заказы",
        "Чаты",
        "Меню",
    )
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            Modifier.fillMaxWidth()
            TopAppBar(
                title = {
                    TopBar(text = "Тути калон (12.13 с)", onClick = {
                                                                    check = !check
                    }, textButton = "AUTO", color = if(check)Color.Green else Color.Red)
                },
                backgroundColor = Color.Black,
            )


        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
            }
        },
        drawerContent = { Text(text = "Drawer Menu 1") },
        drawerShape = MaterialTheme.shapes.large,
        drawerElevation = 150.dp,
        drawerBackgroundColor = Color(color = 0xFF9AD0FA),
        drawerScrimColor = Color.Yellow,
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFEBEBEB))
            ) {
                item() {
                    CustomProfile(
                        showProfile = "bakha",
                        phoneNumber = "876543",
                        icon = R.drawable.profil
                    )

                    Spacer(modifier = Modifier.height(9.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(20.dp)
                            )
                            .background(Color.White)
                            .padding(start = 30.dp, top = 18.dp, bottom = 18.dp, end = 20.dp)
                    ) {
                        Spacer(modifier = Modifier.height(9.dp))
                        Text(
                            text = "УВЕДОМЛЕНИЯ О ЗАКАЗАХ", fontSize = 16.sp,
                        )
                        CustomTextSwitch(
                            text = "Междугородние",
                            checkedState = checkedState.value,
                            onCheckedChange = { checkedState.value = it })
                        CustomTextSwitch(
                            text = "Городские",
                            checkedState = checkedState2.value,
                            onCheckedChange = { checkedState2.value = it })
                    }
                    Spacer(modifier = Modifier.height(9.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(20.dp)
                            )
                            .background(Color.White)
                            .padding(start = 30.dp, top = 18.dp, bottom = 18.dp, end = 20.dp)
                    ) {
                        CustomField(icon = R.drawable.service, text = "Сервисы")

                        Spacer(modifier = Modifier.height(15.dp))

                        CustomField(icon = R.drawable.money, text = "Деньги")

                    }

                    Spacer(modifier = Modifier.height(9.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(
                                    20.dp
                                )
                            )
                            .background(Color.White)
                            .padding(start = 30.dp, top = 18.dp, bottom = 18.dp, end = 20.dp),

                        ) {
                        CustomField(icon = R.drawable.help, text = "Поддержка")

                        Spacer(modifier = Modifier.height(17.dp))

                        CustomField(icon = R.drawable.settings, text = "Параметры")
                        Spacer(modifier = Modifier.height(17.dp))

                        CustomField(icon = R.drawable.info, text = "О приложении")

                        Spacer(modifier = Modifier.height(17.dp))

                        CustomField(icon = R.drawable.back, text = "Выход")
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar(backgroundColor = Color.Black) {
                repeat(textList.count()) {
                    BottomNavigationItem(
                        selected = false,

                        onClick = {
                            Toast.makeText(context, "${counter[it]}", Toast.LENGTH_SHORT).show()
                        }, icon = {
                            CustomBottomBar(painter = iconList[it], text = textList[it])
                        })
                }
            }
        }
    )
}

@Composable
fun CustomField(
    icon:Int,
    text:String
){
    Row {
        Image(
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(20.dp))

        Text(text = text)
    }
}
@Composable
fun CustomTextSwitch(
    text:String,
    checkedState:Boolean,
    onCheckedChange:(Boolean)->Unit
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 15.dp, end = 15.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            modifier = Modifier.padding(top = 17.dp, bottom = 16.dp),
            text = text, fontSize = 16.sp,
        )
        Switch(checked = checkedState,
            onCheckedChange = {onCheckedChange(it) })
    }
}
@Composable
fun CustomProfile(
    showProfile:String,
    phoneNumber:String,
    icon:Int
){
    Row(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .background(Color.White)
            .padding(20.dp)
            .padding(start = 30.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(14.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = phoneNumber, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = showProfile,
                fontSize = 16.sp,
            )
        }

    }
}
@Composable
fun TopBar(
    text:String,
    onClick:()->Unit,
    textButton:String,
    color: Color
    ){
    Row(modifier = Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text, color = Color.White)
        Button(
            colors = ButtonDefaults.buttonColors(color),
            onClick = { onClick() }
        ) {
            Text(text = textButton, color = Color.White)
        }
    }
}