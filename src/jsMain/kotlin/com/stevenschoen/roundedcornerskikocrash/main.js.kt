package com.stevenschoen.roundedcornerskikocrash

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
  onWasmReady {
    Window("Hello") {
      var shape by remember { mutableStateOf(RectangleShape) }

      Column {
        BasicText(
          "RectangleShape",
          Modifier.clickable { shape = RectangleShape }
        )
        BasicText(
          "RoundedCornerShape(16.dp)",
          Modifier.clickable { shape = RoundedCornerShape(16.dp) }
        )
        BasicText(
          "RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)",
          Modifier.clickable { shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp) }
        )

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
