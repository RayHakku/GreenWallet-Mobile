package com.example.greenwallet.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTextFieldComponent(
    placeholderValue:String,
    onTextSelected: (String) -> Unit,
) {
    val textValue = remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current

    TextField(
        value = textValue.value ,
        onValueChange = {
            textValue.value = it
            onTextSelected(it)
                        },
        modifier = Modifier
            .fillMaxWidth()
            .height(53.dp),
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
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    placeholderValue: String,
    onTextSelected: (String) -> Unit,
) {

    var passwordValue = remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current

    TextField(
        value = passwordValue.value,
        onValueChange = { passwordValue.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .height(53.dp),
        shape = MaterialTheme.shapes.medium,
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
        )
    )
}