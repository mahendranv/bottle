package com.ex2.bottle.ui.screens.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ex2.bottle.ui.common.DemoScaffold
import com.ex2.bottle.ui.custom.BottomAppBar1

@Composable
fun BottomNavVariants() {
    DemoScaffold(title = "Custom - Bottom bars") {
        LazyColumn {

            // variant #1
            item {
                BottomBarLineItem {
                    BottomAppBar1(modifier = Modifier.fillMaxWidth(1f))
                }
            }
        }
    }
}

@Composable
private fun BottomBarLineItem(content: @Composable () -> Unit) {

    Text(
        text = "Dotted variant",
        fontStyle = MaterialTheme.typography.h4.fontStyle,
        modifier = Modifier.padding(top = 24.dp, bottom = 16.dp, start = 36.dp),
    )
    content()
    Divider()
}