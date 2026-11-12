package com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.e_commerce_app.ui.theme.AppStyles


@Composable
fun MainSectionLayout(modifier: Modifier = Modifier,
                      text: String,
                      onViewAllClick :()-> Unit ={},
                      textButton : String
) {
    Row(
        modifier= Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            style = AppStyles.reg18Primary,
        )
        TextButton(
            onClick = onViewAllClick,
        ) {
            Text(
                text = textButton,
                style = AppStyles.reg18Primary,
            )
        }
    }
}
