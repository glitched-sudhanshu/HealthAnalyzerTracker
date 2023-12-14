package com.example.healthanalyzertracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthanalyzertracker.R
import com.example.healthanalyzertracker.ui.theme.BackgroundGrey
import com.example.healthanalyzertracker.ui.theme.DarkPaleBlue
import com.example.healthanalyzertracker.ui.theme.Grey
import com.example.healthanalyzertracker.ui.theme.LightBlue
import com.example.healthanalyzertracker.ui.theme.LightPaleBlue
import com.example.healthanalyzertracker.utils.DiseaseType

@Composable
fun DiseaseList(
  onClick: (DiseaseType) -> Unit
) {
  ConstraintLayout(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .padding(start = 15.dp, end = 15.dp, top = 15.dp)
      .background(color = BackgroundGrey)
      .verticalScroll(rememberScrollState())
  )
  {
    val (diabetesCard, liverCard, strokeCard, cancerCard, heartDiseaseCard, fetalHealthCard, whiteBox) = createRefs()
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp - 30.dp - 10.dp
    val screenHeight = (screenWidth * 3) / 4
    val typeCardShadow = Modifier.shadow(
      color = DarkPaleBlue,
      offsetX = 20.dp,
      offsetY = 20.dp,
      spread = 2.dp,
      borderRadius = 20.dp,
      blurRadius = 10.dp,
    )
    val context = LocalContext.current

    TypeCard(
      modifier = typeCardShadow
        .constrainAs(heartDiseaseCard) {
          linkTo(start = parent.start, end = parent.end, bias = 0f)
          top.linkTo(parent.top, margin = 25.dp)
        },
      height = screenHeight,
      width = screenWidth / 2,
      cardTitle = "Heart Disease",
      diseaseIcon = R.drawable.ic_heart_disease,
      cardTitleColor = Color.White,
      backgroundColor = LightBlue,
      iconTint = Color.White,
      cardIcon = Icons.Filled.ArrowCircleRight,
      showIcon = true,
      diseaseType = DiseaseType.HEART,
      onCardClick = {
        onClick(it)
      }
    )

    TypeCard(
      modifier = typeCardShadow
        .constrainAs(diabetesCard) {
          linkTo(start = parent.start, end = parent.end, bias = 1f)
          top.linkTo(parent.top, margin = 25.dp)
        }, height = screenHeight / 2,
      width = screenWidth / 2,
      cardTitle = "Diabetes",
      diseaseIcon = R.drawable.ic_diabetes,
      cardTitleColor = DarkPaleBlue,
      backgroundColor = Grey,
      iconTint = LightPaleBlue,
      diseaseType = DiseaseType.DIABETES,
      onCardClick = {
        onClick(it)
      },
      cardIcon = Icons.Filled.AddAlert,
      showIcon = false
    )


    TypeCard(
      modifier = typeCardShadow
        .constrainAs(liverCard) {
          linkTo(start = parent.start, end = parent.end, bias = 1f)
          top.linkTo(diabetesCard.bottom, margin = 10.dp)
        }, height = ((screenHeight / 2) - 10.dp),
      width = screenWidth / 2,
      cardTitle = "Liver Problem",
      cardTitleColor = DarkPaleBlue,
      diseaseIcon = R.drawable.ic_liver,
      diseaseType = DiseaseType.LIVER,
      onCardClick = {
        onClick(it)
      },
      backgroundColor = Grey,
      iconTint = LightPaleBlue,
      cardIcon = Icons.Filled.Star,
      showIcon = false
    )


    TypeCard(
      modifier = typeCardShadow
        .constrainAs(cancerCard) {
          linkTo(start = parent.start, end = parent.end, bias = 1f)
          top.linkTo(liverCard.bottom, margin = 25.dp)
        },
      height = screenHeight,
      width = screenWidth / 2,
      cardTitle = "Breast Cancer",
      diseaseIcon = R.drawable.ic_breast_cancer,
      cardTitleColor = Color.White,
      diseaseType = DiseaseType.CANCER,
      onCardClick = {
        onClick(it)
      },
      backgroundColor = LightBlue,
      iconTint = Color.White,
      cardIcon = Icons.Filled.ArrowCircleRight,
      showIcon = true
    )

    TypeCard(
      modifier = typeCardShadow
        .blur(2.dp, 2.dp)
        .constrainAs(strokeCard) {
          linkTo(start = parent.start, end = parent.end, bias = 0f)
          top.linkTo(heartDiseaseCard.bottom, margin = 25.dp)
        }, height = screenHeight / 2,
      width = screenWidth / 2,
      cardTitle = "Stroke",
      diseaseIcon = R.drawable.ic_stroke,
      cardTitleColor = DarkPaleBlue,
      diseaseType = DiseaseType.STROKE,
      onCardClick = {
        onClick(it)
      },
      backgroundColor = Grey,
      iconTint = LightPaleBlue,
      cardIcon = Icons.Filled.AddAlert,
      showIcon = false
    )


    TypeCard(
      modifier = typeCardShadow
        .constrainAs(fetalHealthCard) {
          linkTo(start = parent.start, end = parent.end, bias = 0f)
          top.linkTo(strokeCard.bottom, margin = 10.dp)
        }, height = ((screenHeight / 2) - 10.dp),
      width = screenWidth / 2,
      cardTitle = "Fetal Health",
      cardTitleColor = DarkPaleBlue,
      diseaseIcon = R.drawable.ic_fetal_health,
      diseaseType = DiseaseType.FETAL_HEALTH,
      onCardClick = {
        onClick(it)
      },
      backgroundColor = Grey,
      iconTint = LightPaleBlue,
      cardIcon = Icons.Filled.Star,
      showIcon = false
    )

    Box(modifier = Modifier
      .fillMaxWidth()
      .height(20.dp)
      .constrainAs(whiteBox) {
        linkTo(parent.start, parent.end)
        top.linkTo(cancerCard.bottom)
      })
  }
}