package com.example.e_commerce_app.ui.theme.feature.commerce.ui.Screens.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.e_commerce_app.R
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Category.CategoryTab
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Favourite.FavouriteTab
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Home.HomeTab
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.Tabs.Profile.ProfileTab
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.component.CustomBottomBar1
import com.example.e_commerce_app.ui.theme.feature.commerce.ui.component.CustomTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier= Modifier, fullName: String){
    val colorScheme = MaterialTheme.colorScheme
    var selectedIndex by remember { mutableIntStateOf(0) }
    var searchValue by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(

                title = {
            Column() {
                Image(
                    painter = painterResource(R.drawable.mini_route_logo),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(12.dp)
                        .height(40.dp)
                        .size(80.dp)

                )
                SearchLayout(
                    searchValue = searchValue,
                    onValueChange = {
                        newValue ->
                        searchValue= newValue
                    },
                    hintText = "what do you search for?"
                )
            }
                }
            )
        },
        bottomBar = {
            CustomBottomBar1(
                colorScheme = colorScheme,
                selectedIndex = selectedIndex,
                onTabClick = {
                    index ->
                    selectedIndex = index
                },
            )
        }
    ){ innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            when (selectedIndex){
                0 -> {
                    HomeTab()
                }
                1 -> {
                    CategoryTab()
                }
                2 -> {
                    FavouriteTab()
                }
                3 -> {
                    ProfileTab()
                }

            }

        }
    }
}
@Composable
fun SearchLayout(modifier: Modifier = Modifier,
                 searchValue : String,
                 onValueChange : (String) -> Unit,
                 hintText: String,
                 ) {
    Row(
        modifier= Modifier.fillMaxWidth() ,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CustomTextField(
            value = searchValue,
            onValueChange = onValueChange,
            hintText = hintText,
            modifier = Modifier.weight(5f),
            leadingIcon = {
                Image(
                    painter = painterResource(
                        id = R.drawable.search_icon,
                    ),
                    contentDescription = "search",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 16.dp),
                )
            },
            size = 50.dp
        )
        Image(
            painter = painterResource(
                id = R.drawable.carticon,
            ),
            contentDescription = "cart",
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f)
                .size(35.dp),
             )

    }
}

