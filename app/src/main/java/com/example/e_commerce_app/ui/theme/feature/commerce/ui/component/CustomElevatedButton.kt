package com.example.e_commerce_app.ui.theme.feature.commerce.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomElevatedButton(
    modifier: Modifier= Modifier,
    text :String,
    onClick :() -> Unit
    ){
    ElevatedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 24.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = colorScheme.primary,
                textAlign = TextAlign.Center,
            ),
        )
    }
}