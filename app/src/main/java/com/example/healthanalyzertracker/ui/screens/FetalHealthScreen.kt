package com.example.healthanalyzertracker.ui.screens

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
fun FetalHealthScreen() {
  val context = LocalContext.current
  var showAgeBottomSheet by remember { mutableStateOf(false) }
  var showHighBpBottomSheet by remember { mutableStateOf(false) }
  var showLowBpBottomSheet by remember { mutableStateOf(false) }
  var ageString by remember {
    mutableStateOf("Select your age")
  }
  var highBpString by remember {
    mutableStateOf("Select your high BP")
  }
  var lowBpString by remember {
    mutableStateOf("Select your low BP")
  }
  var afp by remember {
    mutableStateOf("")
  }
  var hcg by remember {
    mutableStateOf("")
  }
  var estriol by remember {
    mutableStateOf("")
  }
  var inhibin by remember {
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
  var glucose by remember {
    mutableStateOf("")
  }
  var calcium by remember {
    mutableStateOf("")
  }
  var bp by remember {
    mutableStateOf("")
  }
  var tsh by remember {
    mutableStateOf("")
  }
  var iron by remember {
    mutableStateOf("")
  }
  var age = 0
  var highBp = 0
  var lowBp = 0

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
      text = "Alpha-Fetoprotein",
      label = "AFP",
      onTextChange = { afp = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Human Chorionic Gonadotropin(hCG)",
      label = "hCG",
      onTextChange = { hcg = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Estriol",
      label = "Estriol",
      onTextChange = { estriol = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Inhibin A",
      label = "Inhibin",
      onTextChange = { inhibin = it },
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
      text = "Blood Glucose Levels",
      label = "Glucose",
      onTextChange = { glucose = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Calcium Levels",
      label = "Calcium",
      onTextChange = { calcium = it },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
      BottomSheetDropDown(
        text = lowBpString,
        modifier = Modifier
          .wrapContentWidth()
          .wrapContentHeight()
      ) {
        showLowBpBottomSheet = true
      }
      Spacer(modifier = Modifier.height(30.dp))
      BottomSheetDropDown(
        text = highBpString,
        modifier = Modifier
          .wrapContentWidth()
          .wrapContentHeight()
      ) {
        showHighBpBottomSheet = true
      }
    }
    Spacer(modifier = Modifier.height(30.dp))
    InputField(
      text = "Thyroid Function Tests",
      label = "TSH",
      onTextChange = { tsh = it },
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
                age, afp, hcg, estriol,
                inhibin, rbc, wbc, platelets, glucose, calcium, lowBp, highBp, tsh, iron
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
  age: Int,
  afp: String,
  hcg: String,
  estriol: String,
  inhibin: String,
  rbc: String,
  wbc: String,
  platelets: String,
  glucose: String,
  calcium: String,
  lowBp: Int,
  highBp: Int,
  tsh: String,
  iron: String
): Boolean {
  if (afp.isBlank() || hcg.isBlank() || estriol.isBlank() || inhibin.isBlank() || rbc.isBlank() || wbc.isBlank() || platelets.isBlank() || glucose.isBlank() || calcium.isBlank() || lowBp == 0 || highBp == 0 || tsh.isBlank() || iron.isBlank() || age == 0) return false
  return true
}

@Preview
@Composable
fun PreviewFetalHealthScreen() {
  FetalHealthScreen()
}