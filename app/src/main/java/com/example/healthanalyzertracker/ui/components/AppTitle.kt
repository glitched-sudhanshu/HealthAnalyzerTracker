package com.example.healthanalyzertracker.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.healthanalyzertracker.ui.theme.AudioWideFont
import com.example.healthanalyzertracker.ui.theme.Cyan
import com.example.healthanalyzertracker.ui.theme.LightBlue
import com.example.healthanalyzertracker.ui.theme.Pink40

@Composable
fun AppTitle(text: String = "~~Health~~ \n~~Analyzer~~ \n~~System~~")
{
  val gradientColors = listOf(Cyan, LightBlue, Pink40)
  Text(
    text = text, fontSize = 65.sp,
    fontFamily = AudioWideFont.fontFamily,
    style = TextStyle(
      brush = Brush.linearGradient(
        colors = gradientColors
      ),
      textAlign = TextAlign.Center
    )
  )
}