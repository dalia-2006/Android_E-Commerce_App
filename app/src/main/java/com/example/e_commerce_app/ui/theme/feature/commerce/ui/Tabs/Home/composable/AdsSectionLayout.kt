package com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.e_commerce_app.R
import com.example.e_commerce_app.ui.theme.AppStyles

@Composable
fun AdsSectionLayout(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(
            id = R.drawable.ad1,
        ),
        contentDescription = "Ad1",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),

        )
}
