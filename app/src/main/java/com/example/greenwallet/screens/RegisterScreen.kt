

package com.example.greenwallet.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.greenwallet.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

private var mDatabaseReference: DatabaseReference? = null
private var mDatabase: FirebaseDatabase? = null
private var mAuth: FirebaseAuth? = null
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var userTerms by remember { mutableStateOf(false) }



    fun navigateToRegisterSuccess() {
        navController.popBackStack()
        navController.navigate(ScreensRoutes.RegisterSuccessScreen.route)
    }
    fun navigateToLogin() {
        navController.popBackStack()
        navController.navigate(ScreensRoutes.LoginScreen.route)
    }

    fun navigateBack(){
        navController.navigate(ScreensRoutes.GetStartedScreen.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.hsl(104F, 1F, 0.9F, 1f)),
    ){
        Column(
              modifier = Modifier
                  .padding(20.dp)
                  .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .clickable {
                        navigateBack()
                    }
            )
            Text(
                text = "Crie sua conta",
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 20.dp, start = 15.dp)
            )
            Text(
                text = "Lorem ipsum dolor sit amet.",
                fontSize = 14.sp,
                color = Color.hsl(0F, 0F, 0F, 0.45f),
                modifier = Modifier
                    .padding(top = 5.dp, start = 20.dp, bottom = 15.dp)
            )
            Text(
                text = "Primeiro Nome",
                modifier = Modifier
                    .padding(start = 5.dp, top = 15.dp, bottom = 2.dp)
            )
            TextField(
                value = firstName,
                onValueChange = { firstName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(53.dp),
                shape = MaterialTheme.shapes.medium,
                placeholder = {
                    Text(
                        text = "Digite seu primeiro nome",
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.hsl(104f, 0.62f, 0.51f, 0.4f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color.hsl(0F, 0F, 0F, 0.3f),
                    cursorColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                singleLine = true,
            )
            Text(
                text = "Sobrenome",
                modifier = Modifier
                    .padding(start = 5.dp,bottom = 2.dp)
            )
            TextField(
                value = lastName,
                onValueChange = { lastName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(53.dp),
                shape = MaterialTheme.shapes.medium,
                placeholder = {
                    Text(
                        text = "Digite seu sobrenome",
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.hsl(104f, 0.62f, 0.51f, 0.4f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color.hsl(0F, 0F, 0F, 0.3f),
                    cursorColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                singleLine = true,

            )
            Text(
                text = "CPF",
                modifier = Modifier
                    .padding(start = 5.dp,bottom = 2.dp)
            )
            TextField(
                value = cpf,
                onValueChange = { cpf = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(53.dp),
                shape = MaterialTheme.shapes.medium,
                placeholder = {
                    Text(
                        text = "Digite seu CPF",
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.hsl(104f, 0.62f, 0.51f, 0.4f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color.hsl(0F, 0F, 0F, 0.3f),
                    cursorColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                )
            )
            Text(
                text = "Email",
                modifier = Modifier
                    .padding(start = 5.dp,bottom = 2.dp)
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(53.dp),
                shape = MaterialTheme.shapes.medium,
                placeholder = {
                    Text(
                        text = "Digite seu email",
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.hsl(104f, 0.62f, 0.51f, 0.4f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color.hsl(0F, 0F, 0F, 0.3f),
                    cursorColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                )
            )
            Text(
                text = "Senha",
                modifier = Modifier
                    .padding(start = 5.dp,bottom = 2.dp)
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(53.dp),
                shape = MaterialTheme.shapes.medium,
                placeholder = {
                    Text(
                        text = "Digite sua senha",
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                singleLine = true,
                visualTransformation =  PasswordVisualTransformation(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.hsl(104f, 0.62f, 0.51f, 0.4f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color.hsl(0F, 0F, 0F, 0.3f),
                    cursorColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                )
            )
            Text(
                text = "Confirme a Senha",
                modifier = Modifier
                    .padding(start = 5.dp,bottom = 2.dp)
            )
            val localFocusManager = LocalFocusManager.current
            TextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth()
                    .height(53.dp),
                shape = MaterialTheme.shapes.medium,
                placeholder = {
                    Text(
                        text = "Confirme sua senha",
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        localFocusManager.clearFocus()
                    }
                ),
                singleLine = true,
                visualTransformation =  PasswordVisualTransformation(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.hsl(104f, 0.62f, 0.51f, 0.4f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color.hsl(0F, 0F, 0F, 0.3f),
                    cursorColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                )
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = userTerms,
                    onCheckedChange = { userTerms = it },
                )
                Text(
                    text ="Eu aceito os termos de uso"
                )
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
             {
                Button(
                    onClick = {
                        navigateToRegisterSuccess()
                              },
                    shape = MaterialTheme.shapes.small,
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                        contentColor = Color.White,
                    ),
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .fillMaxWidth(0.5f)
                ) {
                    Text(
                        text ="Criar Conta",
                        fontWeight = FontWeight.Bold,
                    )
                }
                Text(
                    text ="Ja possui uma conta?"
                )
                Button(
                    onClick = {
                        navigateToLogin()
                              },
                    shape = MaterialTheme.shapes.small,
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = Color.hsl(104F, 0.62F, 0.51F, 0.1f),
                        contentColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
                    ),
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxWidth(0.5f)
                ) {
                    Text(
                        text ="Entrar",
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun RegisterPrev() {
    RegisterScreen(rememberNavController())
}