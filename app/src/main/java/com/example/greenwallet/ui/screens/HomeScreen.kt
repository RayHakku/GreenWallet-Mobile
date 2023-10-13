package com.example.greenwallet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenwallet.R
import com.example.greenwallet.data.classes.SharedPreferencesProvider
import com.example.greenwallet.ui.CardBalance
import com.example.greenwallet.ui.CardBanks
import com.example.greenwallet.ui.CardIncomeExpenses
import com.example.greenwallet.ui.CardTrasanction
import com.example.greenwallet.ui.DropDownMenu
import com.example.greenwallet.ui.NavigationBottomBar
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(navController: NavController, s: String) {

    val auth = FirebaseAuth.getInstance()
    val sharedPreferencesProvider = SharedPreferencesProvider(LocalContext.current)

    fun logout(){
        auth.signOut()
        sharedPreferencesProvider.saveBoolean("rememberMe", false)
        navController.popBackStack()
        navController.navigate("login_screen")
    }



    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color.hsl(104F, 1F, 0.9F, 1f))
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .weight(1f, false)
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
                    logout()
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CardBalance(balanceText = stringResource(R.string.total_balance), balanceValue = "R$ 0,00")
                Spacer(modifier = Modifier.height(16.dp))
                CardIncomeExpenses(ValueIncome = "R$ 10,00", ValueExpenses = "R$10,00")
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
                        text = stringResource(R.string.banks),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.hsl(112f,1f,0.09f,1f)
                    )
                }
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
                LazyRow(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    content = {
                        items(10){
                            CardBanks(items = it, namebank = "Banco", valueBalance =  "R$ 0,00")
                        }
                    } )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Divider(
                modifier =  Modifier
                    .fillMaxWidth(),
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(15.dp))
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(R.string.transactions),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = stringResource(R.string.see_all),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Text(
                    text = "Hoje",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp),
                    content = {
                    items(10){
                        CardTrasanction(
                            nameTransaction = "Compra",
                            nameDescription = "Descricao",
                            valueTransaction = "R$ 0,00",
                        )
                    }
                })
            }
        }
        NavigationBottomBar(navController = navController, userId =  s)
    }

}





@Preview (showBackground = true)
@Composable
fun HomePrev() {
    HomeScreen(rememberNavController(), "teste")
}
