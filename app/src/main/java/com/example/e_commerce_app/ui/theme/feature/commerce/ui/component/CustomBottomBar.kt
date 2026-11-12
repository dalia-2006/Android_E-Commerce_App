package com.example.e_commerce_app.ui.theme.feature.commerce.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

data class Tabs (val icon : ImageVector,val index : Int)
val tabsList = listOf<Tabs>(
    Tabs(icon = Icons.Default.Home, index = 0),
    Tabs(icon = Icons.Default.Category, index = 1),
    Tabs(icon = Icons.Default.FavoriteBorder, index = 2),
    Tabs(icon = Icons.Default.PersonOutline, index = 3),
    )

val  iconsList=listOf(
    Icons.Default.Home,
    Icons.Default.Category,
    Icons.Default.FavoriteBorder,
    Icons.Default.PersonOutline
)

@Composable
fun CustomBottomBar(modifier: Modifier = Modifier,
                    colorScheme : ColorScheme,
                    selectedIndex : Int,
                    onTabClick : (Int) -> Unit
                    ) {
    val colorScheme = MaterialTheme.colorScheme
    NavigationBar(
        containerColor = colorScheme.primary,
    ) {
        iconsList.forEachIndexed { index, vector ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    onTabClick(index)
                },
                label = null,
                icon = {
                    Icon(
                        iconsList[index],
                        contentDescription = null,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorScheme.primary,
                    unselectedIconColor = colorScheme.secondary,

                    )
            )
        }
    }
}
  //  ============================================================
  @Composable
  fun CustomBottomBar1(modifier: Modifier = Modifier,
                      colorScheme : ColorScheme,
                      selectedIndex : Int,
                      onTabClick : (Int) -> Unit
  ) {
      val colorScheme = MaterialTheme.colorScheme
      NavigationBar(
          containerColor = colorScheme.primary,
      ) {
          tabsList.map { tabs ->
              NavigationBarItem(
                  selected = selectedIndex == tabs.index ,
                  onClick = {
                      onTabClick(tabs.index)
                  } ,
                  label = null ,
                  icon = {
                      Icon(
                          iconsList[tabs.index],
                          contentDescription = null,
                      )
                  },
                  colors = NavigationBarItemDefaults.colors(
                      selectedIconColor = colorScheme.primary,
                      unselectedIconColor = colorScheme.secondary,

                      )
              )

          }
      }
  }


