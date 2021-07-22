package com.ex2.bottle.ui.screens.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ex2.bottle.data.model.Demo
import com.ex2.bottle.ui.common.DemoScaffold
import com.ex2.bottle.ui.nav.MainDestinations

@Composable
fun MainScreen() {
    Surface {
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
            ColorAnimationDemo(navController = navController)
        }

        composable(MainDestinations.ShapeAnimation) {
            ShapeAnimationDemo(navController = navController)
        }
    }
}