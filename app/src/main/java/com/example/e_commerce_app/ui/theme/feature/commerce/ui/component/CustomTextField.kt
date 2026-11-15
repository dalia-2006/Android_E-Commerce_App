package com.example.e_commerce_app.ui.theme.feature.commerce.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(
    modifier: Modifier= Modifier,
    value :String,
    onValueChange : (String) -> Unit,
    hintText :String,
    hintStyle : TextStyle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Light,
        color = colorScheme.tertiary,
    ),
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    errorMessage : String? = null,
    supportingText: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    size : Dp? =16.dp
    ){
    OutlinedTextField(
        value = value,
        onValueChange =onValueChange,
        modifier= modifier,
        placeholder = {
            Text(
                text = hintText,
                style = hintStyle,
            )
        },
        isError = !errorMessage.isNullOrBlank(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = colorScheme.secondary,
            unfocusedContainerColor = colorScheme.secondary,
            errorBorderColor = colorScheme.error,
            errorContainerColor = colorScheme.secondary,
            focusedBorderColor = colorScheme.primary,
            unfocusedBorderColor = colorScheme.primary
        ),
        supportingText=supportingText,
        shape = RoundedCornerShape(size!!),
        trailingIcon = trailingIcon,
        leadingIcon=leadingIcon,
        keyboardOptions=keyboardOptions,
        visualTransformation=visualTransformation,
    )
}