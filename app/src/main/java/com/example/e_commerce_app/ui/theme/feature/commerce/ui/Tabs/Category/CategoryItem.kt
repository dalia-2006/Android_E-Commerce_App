package com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.e_commerce_app.R
import com.example.e_commerce_app.ui.theme.AppStyles

@Composable
fun CategoryItemBox(modifier: Modifier = Modifier) {
    Column() {
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                painter = painterResource(R.drawable.category),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            IconButton(
                modifier = Modifier.padding(5.dp),
                onClick = {
                    //todo : on add to favourite click
                }
            ) {
                Icon(
                    Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    tint = colorScheme.primary,
                    modifier= Modifier.clip (CircleShape)
                        .background(color = colorScheme.secondary)
                        .padding(8.dp)
                )
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(
                alignment = Alignment.CenterVertically,
                space = 10.dp
            )

        ) {
            Text(
                text = "Nike Air Jordon" ,
                style = AppStyles.reg14Primary
            )
            Row(modifier= Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "2000 EGP" ,
                    style = AppStyles.reg14Primary
                )
                Text(
                    text = "1200 EGP" ,
                    style = AppStyles.reg14Primary,
                    textDecoration = TextDecoration.LineThrough
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Review" ,
                    style = AppStyles.reg14Primary,
                )
                Text(
                    text = "(4.6)" ,
                    style = AppStyles.reg14Primary,
                )
                Image(
                    painter = painterResource(R.drawable.star),
                    contentDescription = "",
                    modifier= Modifier.size(20.dp)
                )
                IconButton(
                    onClick = {
                        //todo : on add to cart click
                    }
                ) {
                    Icon(
                        Icons.Default.Add,

                        contentDescription = "",
                        tint = colorScheme.secondary,
                        modifier= Modifier.clip (CircleShape)
                            .background(color = colorScheme.primary)
                            .size(35.dp)
                            .padding(3.dp),

                        )
                }

            }

        }
    }
}