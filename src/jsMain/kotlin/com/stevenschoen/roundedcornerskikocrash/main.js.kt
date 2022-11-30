package com.stevenschoen.roundedcornerskikocrash

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        Window {
            var shape by remember { mutableStateOf(RectangleShape) }

            Column {
                DescribeButton(false, "RectangleShape") {
                    shape = RectangleShape
                }
                DescribeButton(false, "RoundedCornerShape(16.dp)") {
                    shape = RoundedCornerShape(16.dp)
                }
                DescribeButton(true, "RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)") {
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                }
                Box(
                    Modifier
                        .size(100.dp)
                        .padding(16.dp)
                        .shadow(8.dp, shape)
                )
            }
        }
    }
}

@Composable
fun DescribeButton(containsBug: Boolean, text: String, onClick: () -> Unit) {
    val color: Color = if (containsBug) Color.Red else Color.Green
    Box {
        BasicText(
            "CLICK ME ($text)",
            Modifier
                .clickable { onClick() }
                .padding(10.dp)
                .background(color.copy(alpha = 0.3f))
                .padding(10.dp)
        )
    }
}
