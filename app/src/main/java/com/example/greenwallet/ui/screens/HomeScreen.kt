package com.example.greenwallet.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenwallet.R
import com.example.greenwallet.ui.DropDownMenu

@Composable
fun HomeScreen(navController: NavController, s: String) {

    /*val auth = FirebaseAuth.getInstance()
    val sharedPreferencesProvider = SharedPreferencesProvider(LocalContext.current)*/

    /*fun logout(){
        auth.signOut()
        sharedPreferencesProvider.saveBoolean("rememberMe", false)
        navController.popBackStack()
        navController.navigate("login_screen")
    }*/



    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(15.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = stringResource(R.string.hello),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium

                )
                Text(
                    text = s,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            DropDownMenu() {
                /*logout()*/
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(

                ){
                    Text(
                        text = "Total Balance",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                    )
                    Text(
                        text = "R$ 0,00",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Arrow Down",
                            tint = Color.Green
                        )
                        Column {
                            Text(
                                text = "Total Income",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "R$ 0,00",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                        }
                    }

                    Divider(
                        modifier = Modifier
                            .height(30.dp)
                            .width(1.dp),
                        color = Color.Black
                    )
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "Arrow Down",
                            tint = Color.Red
                        )
                        Column {
                            Text(
                                text = "Total Expense",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "R$ 0,00",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                        }
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        Divider(
            modifier =  Modifier
                .fillMaxWidth(),
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        Column {
            Row {
                Text(
                    text = "Bancos"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                content = {
                items(10){

                    Card {
                        Row {
                            Icon(imageVector = Icons.Default.Home, contentDescription = "Home Icon")
                            Text(text = "Banco $it")
                        }
                        Column {
                            Text(text = "Saldo")
                            Text(text ="R$ 0,00")
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Divider(
                        modifier = Modifier
                            .height(30.dp)
                            .width(1.dp),
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                }
            } )
        }


        }
}



@Preview (showBackground = true)
@Composable
fun HomePrev() {
    HomeScreen(rememberNavController(), "teste")
}
