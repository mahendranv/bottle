package com.ex2.bottle.ui.common

import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun DemoScaffold(
    title: String,
    showBackArrow: Boolean = true,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = {
            BottleAppBar(title = title, showBackArrow = showBackArrow)
        },
        content = content
    )
}

@Composable
fun BottleAppBar(
    title: String,
    showBackArrow: Boolean = true,
    backPressedDispatcher: OnBackPressedDispatcher? = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
) {
    if (showBackArrow) {
        TopAppBar(
            title = { Text(text = title) },
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 2.dp,
            navigationIcon = { NavIcon(backPressedDispatcher) }
        )
    } else {
        // TODO: Mahendran - nav icon lambda itself expected to be null. Otherwise,
        // the allocated space is taken on the left - even for an empty lambda
        TopAppBar(
            title = { Text(text = title) },
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 2.dp,
        )
    }

}

@Composable
fun NavIcon(
    backPressedDispatcher: OnBackPressedDispatcher? = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
) {
    IconButton(onClick = { backPressedDispatcher?.onBackPressed() }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "navigate back"
        )
    }
}