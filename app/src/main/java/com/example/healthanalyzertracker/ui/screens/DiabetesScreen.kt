package com.example.healthanalyzertracker.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.healthanalyzertracker.ui.components.InputField
import com.example.healthanalyzertracker.ui.theme.AudioWideFont
import com.example.healthanalyzertracker.ui.theme.BackgroundGrey
import com.example.healthanalyzertracker.ui.theme.DarkPaleBlue
import com.example.healthanalyzertracker.ui.theme.LightPaleBlue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DiabetesScreen() {
  val context = LocalContext.current
  var showAgeBottomSheet by remember { mutableStateOf(false) }
  var ageString by remember {
    mutableStateOf("Select your age")
  }
  var fsg by remember {
    mutableStateOf("")
  }
  var ogttFsg by remember {
    mutableStateOf("")
  }
  var ogtt2Fsg by remember {
    mutableStateOf("")
  }
  var heamo by remember {
    mutableStateOf("")
  }
  var randomBloodSugar by remember {
    mutableStateOf("")
  }
  var feelingFatigued by remember {
    mutableStateOf("Feeling Fatigued")
  }
  var urinatingMoreOften by remember {
    mutableStateOf("Urinating More Often")
  }
  var frequentInfections by remember {
    mutableStateOf("Frequent Infections")
  }
  var age by remember {
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
    InputField(
      text = "Fasting blood glucose level",
      label = "Fasting blood glucose ",
      onTextChange = { fsg = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Fasting blood sugar for OGTT",
      label = "Fasting blood sugar for OGTT",
      onTextChange = { ogttFsg = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "2-hour blood glucose level OGTT",
      label = "2-hour blood glucose level OGTT",
      onTextChange = { ogtt2Fsg = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Hemoglobin level",
      label = "Hemoglobin level",
      onTextChange = { heamo = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Random blood sugar level",
      label = "Random blood sugar level",
      onTextChange = { randomBloodSugar = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Yes", "No"),
      selectedText = feelingFatigued,
      labelText = "Feeling Fatigued "
    ) {
      feelingFatigued = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Yes", "No"),
      selectedText = urinatingMoreOften,
      labelText = "Urinating More Often "
    ) {
      urinatingMoreOften = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Yes", "No"),
      selectedText = frequentInfections,
      labelText = "Frequent Infections "
    ) {
      frequentInfections = it
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
                age = age,
                fsg = fsg,
                ogttFsg = ogttFsg,
                ogtt2Fsg = ogtt2Fsg,
                heamo = heamo,
                randomBs = randomBloodSugar,
                feelingFatigued = feelingFatigued,
                urinatingMoreOften = urinatingMoreOften,
                frequentInfections = frequentInfections,
              )
            ) {
              Toast
                .makeText(context, "Fill all fields!", Toast.LENGTH_LONG)
                .show()
            } else CoroutineScope(Dispatchers.Main).launch {
              delay(5000)
              Toast
                .makeText(
                  context,
                  "Error while calling API. Something went wrong!",
                  Toast.LENGTH_LONG
                )
                .show()
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
  fsg: String,
  ogttFsg: String,
  ogtt2Fsg: String,
  heamo: String,
  randomBs: String,
  feelingFatigued: String,
  urinatingMoreOften: String,
  frequentInfections: String,
): Boolean {
  if (fsg.isBlank() || ogttFsg.isBlank() || ogtt2Fsg.isBlank() || heamo.isBlank() || randomBs.isBlank() || feelingFatigued == "Feeling Fatigued" || urinatingMoreOften == "Urinating More Often" || frequentInfections == "Frequent Infections" || age == "") return false
  return true
}

@Preview
@Composable
fun PreviewDiabetesScreen() {
  DiabetesScreen()
}