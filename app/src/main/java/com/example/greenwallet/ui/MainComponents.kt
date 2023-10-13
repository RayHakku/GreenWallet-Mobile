package com.example.greenwallet.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greenwallet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTextFieldComponent(
    placeholderValue:String,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean,
    errorMessage: String,
    labelValue: String,
) {
    val textValue = remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        value = textValue.value ,
        onValueChange = {
            textValue.value = it
            onTextSelected(it)
                        },
        modifier = Modifier
            .fillMaxWidth()
            ,
        shape = MaterialTheme.shapes.medium,
        placeholder = {
            Text(
                text = placeholderValue,
            )
        },
        label = {
            Text(
                text = labelValue,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.hsl(104f, 0.62f, 0.51f, 0.4f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = Color.hsl(0F, 0F, 0F, 0.3f),
            cursorColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
            focusedLabelColor = Color.Black,
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        singleLine = true,
        supportingText = {
            if (!errorStatus) {
                Text(
                    text = errorMessage,
                    fontWeight = FontWeight.Bold,
                )
            }
        },
        isError = !errorStatus,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    placeholderValue: String,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean,
    errorMessage: String,
    labelValue:String,
) {

    val passwordValue = remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        value = passwordValue.value,
        onValueChange = { passwordValue.value = it
            onTextSelected(it)
                        },
        modifier = Modifier
            .fillMaxWidth()
            ,
        shape = MaterialTheme.shapes.medium,
        label = {
            Text(
                text = labelValue,
                modifier = Modifier
            )
        },
        placeholder = {
            Text(
                text = placeholderValue,
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
            focusedLabelColor = Color.Black,
        ),
        supportingText = {
            if (!errorStatus) {
                Text(
                    text = errorMessage,
                    fontWeight = FontWeight.Bold,
                )
            }
        },
        isError = !errorStatus,
    )
}

@Composable
fun SecondaryButtonMedium(
    value: String, onClick: () -> Unit
){
    Button(
        onClick = {
            onClick.invoke()
        },

        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.hsl(104F, 0.62F, 0.51F, 0.1f),
            contentColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
        ),
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth(0.5f),
    ){
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun MainButtonMedium(
    value: String, onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick.invoke()
        },
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
            contentColor = Color.White,
        ),
        modifier = Modifier
            .padding(bottom = 5.dp)
            .fillMaxWidth(0.5f)
    ) {
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CPFTextFieldComponent(
    placeholderValue:String,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean,
    errorMessage: String,
    labelValue: String,
) {
    val textValue = remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        value = textValue.value ,
        onValueChange = {
            textValue.value = it
            onTextSelected(it)
        },
        modifier = Modifier
            .fillMaxWidth()
        ,
        label = {
            Text(
                text = labelValue,
            )
        },
        shape = MaterialTheme.shapes.medium,
        placeholder = {
            Text(
                text = placeholderValue,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.hsl(104f, 0.62f, 0.51f, 0.4f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = Color.hsl(0F, 0F, 0F, 0.3f),
            cursorColor = Color.hsl(104F, 0.62F, 0.51F, 1f),
            focusedLabelColor = Color.Black,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        singleLine = true,
        supportingText = {
            if (!errorStatus) {
                Text(
                    text = errorMessage,
                    fontWeight = FontWeight.Bold,
                )
            }
        },
        isError = !errorStatus,
    )
}

@Composable
fun CheckBoxMainComponent(onCheckedChange: (Boolean) -> Unit) {
    val checkedState = remember {
        mutableStateOf(false)
    }
    Checkbox(
        checked = checkedState.value ,
        onCheckedChange = {
            checkedState.value = !checkedState.value
            onCheckedChange.invoke(it)
        }
    )
}

@Composable
fun DropDownMenu(
    logout: () -> Unit
){
    val context = LocalContext.current
    var expanded by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
    ){
        IconButton(onClick = {
            expanded = !expanded
        }
        )
        {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More Options",
                tint = Color.Black
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
            expanded = false }
        )
        {
            DropdownMenuItem(
                text = { Text(text = stringResource(R.string.logout)) },
                onClick = {
                    logout.invoke()
                }
            )
        }
    }

}

@Composable
fun NavigationBottomBar(
    navController: androidx.navigation.NavController,userId: String
){
    BottomAppBar (
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        containerColor = Color.hsl(104F, 1F, 0.9F, 1f),
        contentColor = Color.hsl(112f,1f,0.09f,1f)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier
                    .clickable {
                        navController.navigate("home_screen/$userId")
                    },
                imageVector = Icons.Default.Home,
                contentDescription = "Home Icon",
                tint = Color.hsl(112f,1f,0.09f,1f)
            )
            Icon(
                modifier = Modifier
                    .clickable {
                        navController.navigate("info_screen/$userId")
                    },
                imageVector = Icons.Default.Info,
                contentDescription = "Info Icon",
                tint = Color.hsl(112f,1f,0.09f,1f)
            )
        }
    }
}
@Composable
fun CardBalance(balanceText: String, balanceValue: String){
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = CardDefaults.cardColors(
           containerColor = Color.hsl(104F, 0.62F, 0.54F, 0.15f),
        ),
        border = BorderStroke(
            width = 1.dp,
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.hsl(112F, 1F, 0.09F, 1f),
                    Color.hsl(112F, 1F, 0.09F, 1f),
                )
            )
        )
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 10.dp)
                ,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = balanceText,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
            )
            Text(
                text = balanceValue,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}
@Composable
fun CardIncomeExpenses(ValueIncome: String, ValueExpenses: String){
    OutlinedCard (
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.hsl(104F, 0.62F, 0.54F, 0.15f),
        ),
        border = BorderStroke(
            width = 1.dp,
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.hsl(112F, 1F, 0.09F, 1f),
                    Color.hsl(112F, 1F, 0.09F, 1f),
                )
            )
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = stringResource(id =(R.string.arrow_down)),
                    tint = Color.Green
                )
                Column (
                ) {
                    Text(
                        text = stringResource(R.string.total_income),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                    )
                    Text(
                        text = ValueIncome,
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
                    contentDescription = stringResource(R.string.arrow_down),
                    tint = Color.Red
                )
                Column {
                    Text(
                        text = stringResource(R.string.total_expense),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                    )
                    Text(
                        text = ValueExpenses,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
    }
}
@Composable
fun CardBanks(items: Int, namebank: String, valueBalance: String){
    OutlinedCard (
        modifier = Modifier
            .height(70.dp)
            .width(130.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.hsl(104F, 0.62F, 0.54F, 0.15f),
        ),
        border = BorderStroke(
            width = 1.dp,
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.hsl(112F, 1F, 0.09F, 1f),
                    Color.hsl(112F, 1F, 0.09F, 1f),
                )
            )
        )

    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp),
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home Icon",
                tint = Color.hsl(82f,1f,0.07f,1f)
            )
            Text(
                text = namebank,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.hsl(82f,1f,0.07f,1f)
            )
        }
        Column (
            modifier = Modifier
                .padding(horizontal = 10.dp),
        ) {
            Text(
                text = stringResource(R.string.balance),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.hsl(82f,1f,0.07f,1f),
            )
            Text(
                text = valueBalance,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
            )
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
@Composable
fun CardTrasanction(nameTransaction: String, nameDescription:String, valueTransaction:String){
    ElevatedCard  (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ) ,
        colors = CardDefaults.cardColors(
            containerColor = Color.hsl(104F, 1F, 0.9F, 1f),
        ),
    ) {
        Row (
            modifier = Modifier
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 15.dp),
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Shopping Cart Icon"
            )
            Column{
                Text(
                    text = nameTransaction,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = nameDescription,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier
                        .padding(end = 10.dp),
                    text =valueTransaction,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

    }
    Spacer(modifier = Modifier.height(10.dp))
}