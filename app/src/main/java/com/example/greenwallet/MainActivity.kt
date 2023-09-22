package com.example.greenwallet

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.greenwallet.navigation.SetupNavGraph
import com.example.greenwallet.ui.theme.GreenWalletTheme

class MainActivity : FragmentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreenWalletTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreenWalletTheme {

    }
}