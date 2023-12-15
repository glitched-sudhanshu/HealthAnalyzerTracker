package com.example.healthanalyzertracker.ui.screens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthanalyzertracker.ui.components.BottomSheet
import com.example.healthanalyzertracker.ui.components.BottomSheetDropDown
import com.example.healthanalyzertracker.ui.components.CustomDropDownMenu
import com.example.healthanalyzertracker.ui.theme.AudioWideFont
import com.example.healthanalyzertracker.ui.theme.BackgroundGrey
import com.example.healthanalyzertracker.ui.theme.DarkPaleBlue
import com.example.healthanalyzertracker.ui.theme.LightPaleBlue
import kotlinx.coroutines.delay

@Composable
fun HeartScreen() {

  val context = LocalContext.current
  var showAgeBottomSheet by remember { mutableStateOf(false) }
  var showPainBottomSheet by remember { mutableStateOf(false) }
  var showHighBpBottomSheet by remember { mutableStateOf(false) }
  var showLowBpBottomSheet by remember { mutableStateOf(false) }
  var showMaxHeartRateBottomSheet by remember { mutableStateOf(false) }
  var showLoader by remember { mutableStateOf(false) }

  LaunchedEffect(key1 = showLoader){
    if(showLoader){
      delay(3000)
      Toast.makeText(context, "Slow internet connection! Taking too long!!", Toast.LENGTH_SHORT).show()
      delay(10000)
      showLoader = false
    }
  }

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
    mutableStateOf("Select your Thalassemia")
  }
  var age by remember {
    mutableStateOf("")
  }
  var chestPain by remember {
    mutableStateOf("")
  }
  var highBp by remember {
    mutableStateOf("")
  }
  var lowBp by remember {
    mutableStateOf("")
  }
  var maxHeartRate by remember {
    mutableStateOf("")
  }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .background(color = BackgroundGrey)
      .padding(horizontal = 16.dp, vertical = 12.dp)
      .fillMaxSize()
      .verticalScroll(rememberScrollState()),
  ) {
    if (showAgeBottomSheet) {
      BottomSheet(
        onDismiss = { showAgeBottomSheet = false },
        minNumValue = 10,
        maxNumValue = 110,
        onNumChange = {
          ageString = "Age: $it"
          age = it
        }
      )
    }
    if (showPainBottomSheet) {
      BottomSheet(onDismiss = { showPainBottomSheet = false },
        minNumValue = 0,
        maxNumValue = 10,
        onNumChange = {
          painString = "Chest pain: $it"
          chestPain = it
        })
    }
    if (showLowBpBottomSheet) {
      BottomSheet(onDismiss = { showLowBpBottomSheet = false }, onNumChange = {
        lowBpString = "Low BP: $it bpm"
        lowBp = it
      }, minNumValue = 50, maxNumValue = 250)
    }
    if (showHighBpBottomSheet) {
      BottomSheet(onDismiss = { showHighBpBottomSheet = false }, onNumChange = {
        highBpString = "High BP: $it bpm"
        highBp = it
      }, minNumValue = 50, maxNumValue = 250)
    }
    if (showMaxHeartRateBottomSheet) {
      BottomSheet(onDismiss = { showMaxHeartRateBottomSheet = false }, onNumChange = {
        maxHeartRateString = "Max Heart Rate: $it bpm"
        maxHeartRate = it
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
      BottomSheetDropDown(
        text = lowBpString, modifier = Modifier
          .wrapContentWidth()
          .wrapContentHeight()
      ) {
        showLowBpBottomSheet = true
      }
      Spacer(modifier = Modifier.height(30.dp))
      BottomSheetDropDown(
        text = highBpString, modifier = Modifier
          .wrapContentWidth()
          .wrapContentHeight()
      ) {
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
      labelText = "Thalassemia "
    ) {
      thal = it
    }

    if(showLoader){
      Spacer(modifier = Modifier.height(30.dp))
      CircularProgressIndicator()
    }
    Spacer(modifier = Modifier.height(30.dp))
    Spacer(modifier = Modifier.height(30.dp))
    Text(
      text = "Submit",
      modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.CenterHorizontally)
        .background(color = LightPaleBlue, RoundedCornerShape(15.dp))
        .clickable(
          onClick = {
            if (!checkIfValid(
                age,
                gender,
                chestPain,
                lowBp,
                highBp,
                fastingBloodSugar,
                cardiographicResult,
                maxHeartRate,
                majorVessels,
                thal
              )
            ) {
              Toast
                .makeText(context, "Fill all fields!", Toast.LENGTH_LONG)
                .show()
            } else {
              showLoader = true
            }
          },
          interactionSource = remember { MutableInteractionSource() },
          indication = rememberRipple(bounded = true)
        )
        .padding(vertical = 10.dp),
      fontFamily = AudioWideFont.fontFamily,
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      color = Color.White,
    )
  }
}

private fun checkIfValid(
  age: String,
  gender: String,
  chestPain: String,
  lowBp: String,
  highBp: String,
  fastingBloodSugar: String,
  cardiographicResult: String,
  maxHeartRate: String,
  majorVessels: String,
  thal: String
): Boolean {
  Log.d("check please", "checkIfValid: $gender \n $age  \n $lowBp  \n  $fastingBloodSugar")
  if(age=="" || gender == "Select your gender" || chestPain == "" || lowBp == "" || highBp == "" || maxHeartRate == "" || fastingBloodSugar == "Select your Fasting Blood Sugar" || cardiographicResult == "Select your Electrocardiographic Result" || majorVessels == "Select your No. of major vessels" || thal == "Select your Thalassemia") return false
  return true
}

@Preview
@Composable
fun PreviewHeartScreen() {
  HeartScreen()
}