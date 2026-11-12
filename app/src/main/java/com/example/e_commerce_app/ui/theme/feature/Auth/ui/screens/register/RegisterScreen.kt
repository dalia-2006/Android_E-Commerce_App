package com.example.e_commerce_app.ui.theme.feature.Auth.ui.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce_app.R
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.component.CustomElevatedButton
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.component.CustomTextField
import com.example.e_commerce_app.ui.theme.core.utils.AppValidators

@Composable
fun RegisterScreen(modifier: Modifier= Modifier,
                   onSignUpClick : (String) -> Unit,
                   ){
    var fullName by remember { mutableStateOf("dodo") }
    var password by remember { mutableStateOf("123456") }
    var rePassword by remember { mutableStateOf("123456") }
    var phone by remember { mutableStateOf("01097917768") }
    var email by remember { mutableStateOf("dodo@route.com") }
    var fullNameError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var rePasswordError by remember { mutableStateOf<String?>(null) }
    var phoneError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordVisible  by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val colorScheme = colorScheme
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(state = scrollState )
        .background(color = colorScheme.primary)
        .padding(16.dp) ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),

    ) {
        RouteLogoSection()
        Text(
            text = "Full Name",
            modifier= Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = colorScheme.secondary,
            )
        )
        CustomTextField(
            modifier = modifier.fillMaxWidth(),
            value = fullName,
            onValueChange = { newValue ->
                fullName = newValue
                fullNameError=null
            },
            hintText = "enter your full name",
            errorMessage = fullNameError,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            supportingText = {
                fullNameError?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            color = colorScheme.error
                        )                    )
                }
            },
        )
        Text(
            text = "Mobile Number",
            modifier= Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = colorScheme.secondary,
            )
        )
        CustomTextField(
            modifier = modifier.fillMaxWidth(),
            value = phone,
            errorMessage = phoneError,
                    onValueChange = { newValue ->
                phone = newValue
                        phoneError=null
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            hintText = "enter your mobile number",
            supportingText = {
                phoneError?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            color = colorScheme.error
                        )                    )
                }
            },
        )
        Text(
            text = "E-mail Address",
            modifier= Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = colorScheme.secondary,
            )
        )
        CustomTextField(
            modifier = modifier.fillMaxWidth(),
            value = email,
            onValueChange = { newValue ->
                email = newValue
                emailError= null
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            hintText = "enter your email address",
            errorMessage = emailError,
            supportingText = {
                emailError?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            color = colorScheme.error
                        )
                    )
                }
            },
            )
        Text(
            text = "Password",
            modifier= Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = colorScheme.secondary,
            )
        )
        CustomTextField(
            modifier = modifier.fillMaxWidth(),
            value = password,
            onValueChange = { newValue ->
                password = newValue
                passwordError=null
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            supportingText = {
                passwordError?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            color = colorScheme.error
                        )                    )
                }
            },
            visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            hintText = "enter your password",
            errorMessage = passwordError,
            trailingIcon = {
                Icon(
                    if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = "visibility",
                    tint = colorScheme.tertiary
                )
            }
        )
        Text(
            text = "confirm Password",
            modifier= Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = colorScheme.secondary,
            )
        )
        CustomTextField(
            modifier = modifier.fillMaxWidth(),
            value = rePassword,
            onValueChange = { newValue ->
                rePassword = newValue
                rePasswordError=null
            },
            visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            supportingText = {
                rePasswordError?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            color = colorScheme.error
                        )                    )
                }
            },
            hintText = "enter your password",
            errorMessage = rePasswordError,
            trailingIcon = {
                Icon(
                    if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = "visibility",
                    tint = colorScheme.tertiary
                )
            }
        )
        CustomElevatedButton(
            text = "Sign up",
            onClick = {
                // todo : register and navigate to login screen
                emailError= AppValidators.validEmail(email)
                fullNameError= AppValidators.validateName(fullName)
                passwordError= AppValidators.validatePassword(password)
                rePasswordError= AppValidators.validateRePassword(password,rePassword)
                phoneError= AppValidators.validatePhone(phone)
                if (emailError == null && fullNameError == null && passwordError == null
                    && rePasswordError == null && phoneError == null ){
                    // todo :  navigate to loginScreen
                    onSignUpClick(fullName)
                }

            }
        )
    }
}
@Composable
fun RouteLogoSection(modifier: Modifier = Modifier){
    Image(
        painter = painterResource(R.drawable.route_logo),
        contentDescription = "Route Logo",
        modifier= Modifier.padding(top = 70.dp)
    )
}
