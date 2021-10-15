package com.pocraft.motionscale

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class SamplesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            LazyColumn {
                items(samples) { item ->
                    SampleItem(
                        name = item.name,
                        onButtonClick = {
                            startActivity(item.intentProvider(context))
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun SampleItem(
    name: String,
    onButtonClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(name)
        Button(onClick = onButtonClick) {
            Text("launch")
        }
    }
}

data class SampleEntry(
    val name: String,
    val intentProvider: (Context) -> Intent
)

val samples: List<SampleEntry> = listOf(
    SampleEntry(
        "main 1",
        MainActivity::newIntent
    ),
    SampleEntry(
        "sample 2",
        Sample2Activity::newIntent
    )
)