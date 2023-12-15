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
fun LiverScreen() {
  val context = LocalContext.current
  var showAgeBottomSheet by remember { mutableStateOf(false) }
  var ageString by remember {
    mutableStateOf("Select your age")
  }
  var alt by remember {
    mutableStateOf("")
  }
  var ast by remember {
    mutableStateOf("")
  }
  var alp by remember {
    mutableStateOf("")
  }
  var ggt by remember {
    mutableStateOf("")
  }
  var rbc by remember {
    mutableStateOf("")
  }
  var wbc by remember {
    mutableStateOf("")
  }
  var platelets by remember {
    mutableStateOf("")
  }
  var bilirubin by remember {
    mutableStateOf("")
  }
  var albumin by remember {
    mutableStateOf("")
  }
  var prothrombinTime by remember {
    mutableStateOf("")
  }
  var iron by remember {
    mutableStateOf("")
  }
  var hepatitisA by remember {
    mutableStateOf("Select your HepatitisA marker")
  }
  var hepatitisB by remember {
    mutableStateOf("Select your HepatitiB marker")
  }
  var hepatitisC by remember {
    mutableStateOf("Select your HepatitisC marker")
  }
  var age = 0

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
          age = it.toInt()
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
      text = "Alanine Aminotransferase",
      label = "ALT",
      onTextChange = { alt = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Aspartate Aminotransferase",
      label = "AST",
      onTextChange = { ast = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Alkaline Phosphatase",
      label = "ALP",
      onTextChange = { alp = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Gamma-Glutamyl Transferase",
      label = "GGT",
      onTextChange = { ggt = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Red Blood Cells (RBC, in K)",
      label = "RBC",
      onTextChange = { rbc = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "White Blood Cells (WBC, in K)",
      label = "WBC",
      onTextChange = { wbc = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Platelets (in K)",
      label = "Platelets",
      onTextChange = { platelets = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Bilirubin",
      label = "Bilirubin",
      onTextChange = { bilirubin = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Albumin",
      label = "Albumin",
      onTextChange = { albumin = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "ProthrombinTime",
      label = "ProthrombinTime",
      onTextChange = { prothrombinTime = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Iron Levels",
      label = "Ferritin",
      onTextChange = { iron = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Yes", "No"),
      selectedText = hepatitisA,
      labelText = "HepatitisA "
    ) {
      hepatitisA = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Yes", "No"),
      selectedText = hepatitisB,
      labelText = "HepatitisB "
    ) {
      hepatitisB = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    CustomDropDownMenu(
      suggestions = listOf("Yes", "No"),
      selectedText = hepatitisC,
      labelText = "HepatitisC "
    ) {
      hepatitisC = it
    }
    Spacer(modifier = Modifier.height(30.dp))
    Text(
      text = "Submit",
      modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.CenterHorizontally)
        .background(color = LightPaleBlue, RoundedCornerShape(15.dp))
        .clickable(
          onClick = {
            if (!checkIfValids(
                age = age,
                alt = alt,
                ast = ast,
                alp = alp,
                ggt = ggt,
                rbc = rbc,
                wbc = wbc,
                platelets = platelets,
                bilirubin,
                albumin,
                prothrombinTime,
                hepatitisA,
                hepatitisB,
                hepatitisC,
                iron
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

private fun checkIfValids(
  age: Int,
  alt: String,
  ast: String,
  alp: String,
  ggt: String,
  rbc: String,
  wbc: String,
  platelets: String,
  bilirubin: String,
  albumin: String,
  prothrombinTime: String,
  hepatitisA: String,
  hepatitisB: String,
  hepatitisC: String,
  iron: String
): Boolean {
  if (alt.isBlank() || ast.isBlank() || alp.isBlank() || ggt.isBlank() || platelets.isBlank() || rbc.isBlank() || wbc.isBlank() || bilirubin.isBlank() || albumin.isBlank() || prothrombinTime.isBlank() || hepatitisA == "Select your HepatitisA marker" || hepatitisB == "Select your HepatitisB marker" || hepatitisC == "Select your HepatitisC marker" || iron.isBlank() || age == 0) return false
  return true
}

@Preview
@Composable
fun PreviewLiverScreen() {
  LiverScreen()
}