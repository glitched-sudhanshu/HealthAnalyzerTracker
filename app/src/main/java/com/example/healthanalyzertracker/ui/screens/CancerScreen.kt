package com.example.healthanalyzertracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthanalyzertracker.ui.components.BottomSheet
import com.example.healthanalyzertracker.ui.components.BottomSheetDropDown
import com.example.healthanalyzertracker.ui.components.CustomDropDownMenu
import com.example.healthanalyzertracker.ui.theme.AudioWideFont
import com.example.healthanalyzertracker.ui.theme.BackgroundGrey
import com.example.healthanalyzertracker.ui.theme.DarkPaleBlue

@Composable
fun CancerScreen() {
  var showAgeBottomSheet by remember { mutableStateOf(false) }
  var ageString by remember {
    mutableStateOf("Select your age")
  }
  var lumpString by remember {
    mutableStateOf("Lumps in breast?")
  }
  var sizeString by remember {
    mutableStateOf("Change in size of Breasts?")
  }
  var rednessString by remember {
    mutableStateOf("Redness?")
  }
  var painString by remember {
    mutableStateOf("Frequent pain in Breasts?")
  }
  var appearanceString by remember {
    mutableStateOf("Change in appearance?")
  }
  var dischargeString by remember {
    mutableStateOf("Fluid Discharge (not Milk)?")
  }
  var textureString by remember {
    mutableStateOf("Changes in Breast skin texture?")
  }

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
        }
      )
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
      suggestions = listOf("Yes", "No", "Maybe"),
      selectedText = lumpString,
      labelText = "Lumps"
    ) {
      lumpString = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Yes", "No", "Maybe"),
      selectedText = sizeString,
      labelText = "Size"
    ) {
      sizeString = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Yes", "No", "Maybe"),
      selectedText = rednessString,
      labelText = "Redness"
    ) {
      rednessString = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Low", "Moderate", "High", "Extreme"),
      selectedText = painString,
      labelText = "Pain"
    ) {
      painString = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Yes", "No", "Maybe"),
      selectedText = appearanceString,
      labelText = "Appearance"
    ) {
      appearanceString = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Yes", "No", "Maybe"),
      selectedText = dischargeString,
      labelText = "Fluid Discharge"
    ) {
      dischargeString = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Yes", "No", "Maybe"),
      selectedText = textureString,
      labelText = "Texture"
    ) {
      textureString = it
    }
  }
}

@Preview
@Composable
fun PreviewCancerScreen() {
  CancerScreen()
}