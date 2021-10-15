package com.pocraft.motionscale.setting

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pocraft.motionscale.ui.theme.MotionScaleTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SettingScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp)
            .background(Color.Transparent),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {

        items(fakeListData) { item: String ->
            Text(
                text = item,
                color = MaterialTheme.colors.onPrimary,
            )
        }
    }
}

@Preview
@Composable
fun PreviewSettingScreen() {
    MotionScaleTheme {
        SettingScreen()
    }
}

val fakeListData: List<String> = List(10) {
    "Item #$it"
}