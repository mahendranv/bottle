package com.ex2.bottle.ui.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ex2.bottle.data.AppSdk
import com.ex2.bottle.ui.nav.MainDemoItems


@ExperimentalMaterialApi
@Composable
fun MainListScreen(
    navController: NavController = rememberNavController()
) {
    LazyColumn {
        items(items = MainDemoItems) { demo ->
            ListItem(text = { Text(text = demo.title) },
                secondaryText = if (demo.description != null) {
                    { Text(text = demo.description ?: "") }
                } else null,
                modifier = Modifier.clickable {
                    navController.navigate(demo.path)
                }
            )
        }
    }
}