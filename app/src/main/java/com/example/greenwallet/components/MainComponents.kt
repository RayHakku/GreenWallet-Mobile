package com.example.greenwallet.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

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

    var passwordValue = remember {
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