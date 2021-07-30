package com.ex2.bottle.ui.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ex2.bottle.data.model.Demo
import com.ex2.bottle.ui.common.DemoScaffold
import com.ex2.bottle.ui.nav.MainDemoItems

@ExperimentalMaterialApi
@Composable
fun MainListScreen(
    navController: NavController = rememberNavController()
) {
    DemoScaffold(title = "Bottle", showBackArrow = false) {
        LazyColumn {
            items(items = MainDemoItems) { demo ->
                DemoListItem(demo = demo, modifier = Modifier
                    .clickable {
                        navController.navigate(demo.path)
                    }
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .fillMaxWidth()
                )
            }
        }
    }
}


@Composable
fun DemoListItem(demo: Demo, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = demo.title,
            style = MaterialTheme.typography.body1
        )
        if (demo.description != null) {
            Text(
                text = demo.description,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Preview(widthDp = 300)
@Composable
fun previewDemoListItem() {
    Surface {
        DemoListItem(
            MainDemoItems[1]
        )
    }
}