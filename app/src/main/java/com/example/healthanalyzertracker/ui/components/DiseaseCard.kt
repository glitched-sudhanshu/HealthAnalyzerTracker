package com.example.healthanalyzertracker.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthanalyzertracker.R
import com.example.healthanalyzertracker.ui.theme.AudioWideFont
import com.example.healthanalyzertracker.ui.theme.LightBlue
import com.example.healthanalyzertracker.utils.DiseaseType

@Composable
fun TypeCard(
  modifier: Modifier = Modifier,
  height: Dp,
  width: Dp,
  cardTitle: String,
  backgroundColor: Color = LightBlue,
  cardTitleColor: Color = Color.White,
  cardIcon: ImageVector = Icons.Filled.ArrowCircleRight,
  iconTint: Color = Color.White,
  @DrawableRes diseaseIcon: Int = R.drawable.ic_diabetes,
  showIcon: Boolean = true,
  onCardClick: (DiseaseType) -> Unit,
  diseaseType: DiseaseType
) {
  Box(
    modifier = modifier
      .height(height)
      .width(width)
      .clip(shape = RoundedCornerShape(20.dp))
      .clickable(
        onClick = {
          onCardClick(diseaseType)
        },
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple(bounded = false)
      )
      .background(color = backgroundColor)
  ) {
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
      ) {
        Text(
          text = cardTitle,
          fontFamily = AudioWideFont.fontFamily,
          fontSize = 26.sp,
          modifier = Modifier
            .padding(top = 15.dp, start = 15.dp, end = 15.dp)
            .wrapContentWidth(),
          color = cardTitleColor
        )
      }
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          painter = painterResource(id = diseaseIcon),
          contentDescription = null,
          tint = Color.Unspecified,
          modifier = Modifier
            .padding(10.dp)
            .size(65.dp)
        )
        if (showIcon) Icon(
          imageVector = cardIcon,
          modifier = Modifier
            .padding(top = 15.dp, end = 15.dp)
            .size(32.dp)
            .clickable(
              onClick = {},
              interactionSource = remember { MutableInteractionSource() },
              indication = rememberRipple(bounded = false)
            ),
          contentDescription = null,
          tint = iconTint,
        )
      }
    }
  }
}

@Preview
@Composable
fun PreviewTypeCard() {
  TypeCard(
    height = 160.dp,
    width = 110.dp,
    cardTitle = "Diabetes",
    onCardClick = {},
    diseaseType = DiseaseType.DIABETES
  )
}