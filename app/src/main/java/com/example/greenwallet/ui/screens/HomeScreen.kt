package com.example.greenwallet.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenwallet.data.classes.SharedPreferencesProvider
import com.example.greenwallet.ui.MainButtonMedium
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(navController: NavController, s: String) {

    val auth = FirebaseAuth.getInstance()
    val sharedPreferencesProvider = SharedPreferencesProvider(LocalContext.current)


    Box(
        modifier = Modifier
            .fillMaxSize(),
        Alignment.Center
    ){
        Column (
            modifier = Modifier
                .fillMaxHeight(),
        )
         {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                border = BorderStroke(1.dp, Color.Black),
            ) {
                Column {
                    Text(text = "Home")
                    Text(
                        s
                    )
                }
            }
             MainButtonMedium(value = "Logout", onClick = ({
                 auth.signOut()
                 sharedPreferencesProvider.saveBoolean("rememberMe", false)
                 navController.popBackStack()
                 navController.navigate("login_screen")
             }))


        }
    }

}

@Preview (showBackground = true)
@Composable
fun HomePrev() {
    HomeScreen(rememberNavController(), "teste")
}