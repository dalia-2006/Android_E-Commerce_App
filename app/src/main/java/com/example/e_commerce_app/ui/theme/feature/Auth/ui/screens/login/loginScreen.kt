package com.example.e_commerce_app.ui.theme.feature.Auth.ui.screens.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.e_commerce_app.R
import com.example.e_commerce_app.ui.theme.core.utils.AppValidators
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.utility.Resource
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.common.MainLoadingSection
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.component.CustomElevatedButton
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.component.CustomTextField

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onCreateAccountClick: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var passwordVisible by remember { mutableStateOf(false) }
    val colorScheme = colorScheme
    val state by viewModel.states.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.effects.collect { effects ->
            when (effects) {
                LoginEffects.OnNavigateToHome -> { onLoginClick() }
                LoginEffects.OnNavigateToRegister -> { onCreateAccountClick() }
                is LoginEffects.ShowToast -> {
                    Toast.makeText(context, effects.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorScheme.primary)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        RouteLogoSection()
        Text(
            text = "Welcome Back to Route",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorScheme.secondary,
            )
        )
        Text(
            text = "Please Sign in with your Email",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                color = colorScheme.secondary,
            )
        )
        Text(
            text = "User Name",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = colorScheme.secondary,
            )
        )
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.email,
            onValueChange = { newValue ->
                viewModel.onIntent(intent = LoginIntent.EmailChanged(email = newValue))
                emailError = null
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            errorMessage = emailError,
            hintText = "enter your email",
        )
        Text(
            text = "Password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = colorScheme.secondary,
            )
        )
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.password,
            onValueChange = { newValue ->
                viewModel.onIntent(intent = LoginIntent.PasswordChanged(password = newValue))
                passwordError = null
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            errorMessage = passwordError,
            hintText = "enter your password",
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "visibility",
                        tint = colorScheme.tertiary
                    )
                }
            }
        )
        Text(
            text = "Forget Password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
                color = colorScheme.secondary,
                textAlign = TextAlign.End
            )
        )

        CustomElevatedButton(
            text = "Login",
            onClick = {
                val emailErr = AppValidators.validEmail(state.email)
                val passErr = AppValidators.validatePassword(state.password)
                emailError = emailErr
                passwordError = passErr
                if (emailErr == null && passErr == null) {
                    viewModel.onIntent(intent = LoginIntent.OnLoginClick)
                }
            }
        )

        RowSection(
            text1 = "Don’t have an account?",
            text2 = "Create Account",
            onCreateAccountClick = { viewModel.onIntent(LoginIntent.OnCreateAccountClick) },
        )

        if (state.loginState is Resource.Loading) {
            MainLoadingSection()
        }
    }
}

@Composable
fun RouteLogoSection(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.route_logo),
        contentDescription = "Route Logo",
        modifier = modifier.padding(top = 70.dp)
    )
}

@Composable
fun RowSection(
    modifier: Modifier = Modifier,
    text1: String,
    text2: String,
    onCreateAccountClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text1,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = colorScheme.secondary
            )
        )
        TextButton(
            onClick = onCreateAccountClick
        ) {
            Text(
                text = text2,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorScheme.secondary,
                )
            )
        }
    }
}
