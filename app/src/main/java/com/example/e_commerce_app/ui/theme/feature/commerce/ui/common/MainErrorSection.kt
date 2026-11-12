package com.example.e_commerce_app.ui.theme.feature.commerce.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.e_commerce_app.ui.theme.AppStyles

@Composable
fun MainErrorSection(modifier: Modifier = Modifier, onTryAgainClick:()-> Unit,
                     errorMessage : String
                     ){
    Box(modifier = Modifier,
        contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.fillMaxSize(),
            ) {
            TextButton(
                onClick = onTryAgainClick,
            ) {
                Text(
                    text = "Try Again",
                    style = AppStyles.reg18Primary
                )
            }
            Text(
                text = errorMessage,
                style = AppStyles.reg18Primary
            )
        }
    }
}