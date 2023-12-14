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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CancerScreen() {
  val context = LocalContext.current
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
      suggestions = listOf("No Pain", "Low", "Moderate", "High", "Extreme"),
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
    Spacer(modifier = Modifier.height(30.dp))

    Row(
      modifier = Modifier
        .fillMaxWidth()
        .background(color = LightPaleBlue, RoundedCornerShape(15.dp))
        .clickable(
          onClick = {
            CoroutineScope(Dispatchers.Main).launch {
              delay(5000)
              Toast
                .makeText(context, "Cannot open gallery. Try again.", Toast.LENGTH_LONG)
                .show()
            }
          },
          interactionSource = remember { MutableInteractionSource() },
          indication = rememberRipple(bounded = true)
        )
        .padding(vertical = 10.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center
    )
    {
      Icon(
        imageVector = Icons.Filled.CameraAlt,
        contentDescription = null,
        tint = Color.White,
        modifier = Modifier.padding(end = 15.dp)
      )
      Text(
        text = "Add scan/image",
        fontFamily = AudioWideFont.fontFamily,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        color = Color.White,
      )
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
                ageString,
                lumpString,
                sizeString,
                rednessString,
                painString,
                appearanceString,
                dischargeString,
                textureString
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
  ageString: String,
  lumpString: String,
  sizeString: String,
  rednessString: String,
  painString: String,
  appearanceString: String,
  dischargeString: String,
  textureString: String
): Boolean {
  if (ageString == "Select your age" || lumpString == "Lumps in breast?" || sizeString == "Change in size of Breasts?" || rednessString == "Change in size of Breasts?" || painString == "Frequent pain in Breasts?" || appearanceString == "Change in appearance?" || dischargeString == "Fluid Discharge (not Milk)?" || textureString == "Changes in Breast skin texture?") return false

  return true

}

@Preview
@Composable
fun PreviewCancerScreen() {
  CancerScreen()
}