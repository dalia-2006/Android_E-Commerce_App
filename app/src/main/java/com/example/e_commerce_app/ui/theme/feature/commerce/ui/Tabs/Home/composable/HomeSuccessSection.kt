package com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.example.e_commerce_app.ui.theme.AppStyles
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.entities.common.CategoryItem
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.common.MainLoadingSection

@Composable
fun HomeSuccessLayout(modifier: Modifier= Modifier,
                      categoriesList: List<CategoryItem>,
){
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier= Modifier.height(300.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(
            count = categoriesList.size,
        ) { index ->
            ItemLayout(
                category = categoriesList[index]
            )
        }
    }



}

@Composable
fun ItemLayout(modifier: Modifier = Modifier,
               category : CategoryItem) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubcomposeAsyncImage(
            model = category.image,
            loading = {
                MainLoadingSection()
            },
            contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp),
            contentScale = ContentScale.FillBounds

        )
//        AsyncImage(
//
//            model = category.image ,
//            contentDescription = "",
//            modifier = Modifier
//                .clip(CircleShape)
//                .size(100.dp),
//            contentScale = ContentScale.FillBounds
//        )
//        Image(
//            painter = painterResource(
//                id = R.drawable.ad1,
//            ),
//            contentDescription = "category item",
//            modifier = Modifier
//                .clip(CircleShape)
//                .size(100.dp),
//            contentScale = ContentScale.Crop
//        )
        Text(
            text = category.name ?: "" ,
            style = AppStyles.reg18Primary,
        )
    }

}
