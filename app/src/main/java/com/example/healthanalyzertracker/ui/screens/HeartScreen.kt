package com.example.healthanalyzertracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDownCircle
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthanalyzertracker.ui.components.BottomSheet
import com.example.healthanalyzertracker.ui.components.CustomDropDownMenu
import com.example.healthanalyzertracker.ui.theme.AudioWideFont
import com.example.healthanalyzertracker.ui.theme.BackgroundGrey
import com.example.healthanalyzertracker.ui.theme.DarkPaleBlue
import com.example.healthanalyzertracker.ui.theme.LightPaleBlue
import com.example.healthanalyzertracker.ui.theme.PlaypenSans

@Composable
fun HeartScreen() {
  var showAgeBottomSheet by remember { mutableStateOf(false) }
  var showPainBottomSheet by remember { mutableStateOf(false) }
  var showHighBpBottomSheet by remember { mutableStateOf(false) }
  var showLowBpBottomSheet by remember { mutableStateOf(false) }
  var showMaxHeartRateBottomSheet by remember { mutableStateOf(false) }
  var ageString by remember {
    mutableStateOf("Select your age")
  }
  var gender by remember {
    mutableStateOf("Select your gender")
  }
  var painString by remember {
    mutableStateOf("Select your chest pain")
  }
  var highBpString by remember {
    mutableStateOf("Select your high BP")
  }
  var lowBpString by remember {
    mutableStateOf("Select your low BP")
  }
  var fastingBloodSugar by remember {
    mutableStateOf("Select your Fasting Blood Sugar")
  }
  var cardiographicResult by remember {
    mutableStateOf("Select your Electrocardiographic Result")
  }
  var maxHeartRateString by remember {
    mutableStateOf("Select your Maximum Heart Rate")
  }
  var majorVessels by remember {
    mutableStateOf("Select your No. of major vessels")
  }
  var thal by remember {
    mutableStateOf("Select your Thal")
  }
  var age = 0
  var chestPain = 0
  var highBp = 0
  var lowBp = 0
  var maxHeartRate = 0

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .background(color = BackgroundGrey)
      .padding(horizontal = 16.dp, vertical = 12.dp)
      .fillMaxSize(),
  ) {
    if (showAgeBottomSheet) {
      BottomSheet(
        onDismiss = { showAgeBottomSheet = false },
        minNumValue = 10,
        maxNumValue = 110,
        onNumChange = {
          ageString = "Age: $it"
          age = it.toInt()
        }
      )
    }
    if (showPainBottomSheet) {
      BottomSheet(onDismiss = { showPainBottomSheet = false },
        minNumValue = 0,
        maxNumValue = 10,
        onNumChange = {
          painString = "Chest pain: $it"
          chestPain = it.toInt()
        })
    }
    if (showLowBpBottomSheet) {
      BottomSheet(onDismiss = { showLowBpBottomSheet = false }, onNumChange = {
        lowBpString = "Low BP: $it bpm"
        lowBp = it.toInt()
      }, minNumValue = 50, maxNumValue = 250)
    }
    if (showHighBpBottomSheet) {
      BottomSheet(onDismiss = { showHighBpBottomSheet = false }, onNumChange = {
        highBpString = "High BP: $it bpm"
        highBp = it.toInt()
      }, minNumValue = 50, maxNumValue = 250)
    }
    if (showMaxHeartRateBottomSheet) {
      BottomSheet(onDismiss = { showMaxHeartRateBottomSheet = false }, onNumChange = {
        maxHeartRateString = "Max Heart Rate: $it bpm"
        maxHeartRate = it.toInt()
      }, minNumValue = 10, maxNumValue = 250)
    }
    Text(
      "Enter all the details",
      fontFamily = AudioWideFont.fontFamily,
      fontWeight = FontWeight.Bold,
      fontSize = 20.sp,
      color = DarkPaleBlue
    )
    Spacer(modifier = Modifier.height(30.dp))
    BottomSheetDropDown(text = ageString, modifier = Modifier.fillMaxWidth()) {
      showAgeBottomSheet = true
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Male", "Female"),
      selectedText = gender,
      labelText = "Gender"
    ) {
      gender = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    BottomSheetDropDown(text = painString, modifier = Modifier.fillMaxWidth()) {
      showPainBottomSheet = true
    }
    Spacer(modifier = Modifier.height(30.dp))
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
      BottomSheetDropDown(text = lowBpString, modifier = Modifier.wrapContentWidth().wrapContentHeight()) {
        showLowBpBottomSheet = true
      }
      Spacer(modifier = Modifier.height(30.dp))
      BottomSheetDropDown(text = highBpString, modifier = Modifier.wrapContentWidth().wrapContentHeight()) {
        showHighBpBottomSheet = true
      }
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf(">120 mg/dl", "<120 mg/dl"),
      selectedText = fastingBloodSugar,
      labelText = "Fasting Blood Sugar"
    ) {
      fastingBloodSugar = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("0", "1", "2"),
      selectedText = cardiographicResult,
      labelText = "Electro-Cardiographic result"
    ) {
      cardiographicResult = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    BottomSheetDropDown(text = maxHeartRateString, modifier = Modifier.fillMaxWidth()) {
      showMaxHeartRateBottomSheet = true
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("0", "1", "2", "3"),
      selectedText = majorVessels,
      labelText = "No. of major vessels"
    ) {
      majorVessels = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Normal", "Fixed Defect"),
      selectedText = thal,
      labelText = "Thal"
    ) {
      thal = it
    }
  }
}

@Composable
fun BottomSheetDropDown(text: String, modifier: Modifier = Modifier, onActionClick: () -> Unit) {
  Row(
    modifier = modifier
      .background(color = LightPaleBlue, shape = RoundedCornerShape(15.dp))
      .clickable(
        onClick = { onActionClick() },
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple(bounded = true)
      )
      .padding(vertical = 10.dp, horizontal = 10.dp),
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text(text = text, fontFamily = PlaypenSans.regular, color = BackgroundGrey)
    Icon(
      imageVector = Icons.Filled.ArrowDropDownCircle,
      contentDescription = null,
      tint = Color.White,
      modifier = Modifier.padding(start = 15.dp)
    )
  }
}

@Preview
@Composable
fun PreviewHeartScreen() {
  HeartScreen()
}