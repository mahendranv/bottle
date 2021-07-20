package com.ex2.bottle.ui.screens.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ex2.bottle.ui.nav.MainDestinations

@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Bottle") },
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 2.dp
            )
        }
    ) {
        MainScreenInternal()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun MainScreenInternal() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainDestinations.MainList
    ) {
        composable(MainDestinations.MainList) {
            MainListScreen(navController = navController)
        }

        composable(MainDestinations.ColorAnimation) {
            ColorAnimation(navController = navController)
        }
    }
}