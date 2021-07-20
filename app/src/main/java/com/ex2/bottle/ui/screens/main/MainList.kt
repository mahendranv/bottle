package com.ex2.bottle.ui.screens.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@ExperimentalMaterialApi
@Composable
fun MainListScreen(
    navController: NavController = rememberNavController()
) {
    LazyColumn {
        items(100) { index ->
            ListItem(
                text = { Text("Item $index") },
                secondaryText = { Text("This is a demo item $index. It covers this, that and that") }
            )
        }
    }
}