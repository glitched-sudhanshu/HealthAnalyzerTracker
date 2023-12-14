package com.example.healthanalyzertracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
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
import androidx.compose.ui.unit.dp
import com.example.healthanalyzertracker.ui.components.AppTitle
import com.example.healthanalyzertracker.ui.components.DiseaseList
import com.example.healthanalyzertracker.ui.theme.BackgroundGrey
import com.example.healthanalyzertracker.utils.DiseaseType

@Composable
fun HomeScreen(
  navigateToDiseaseType: (DiseaseType) -> Unit
)
{
  Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color = BackgroundGrey)) {
    var diseaseTypeState: DiseaseType? by remember { mutableStateOf(null) }
    AppTitle()
    Divider(thickness = 1.dp, modifier = Modifier.fillMaxWidth(), color = Color.Gray)

    LaunchedEffect(key1 = diseaseTypeState){
      if(diseaseTypeState != null)navigateToDiseaseType(diseaseTypeState!!)
    }
    val context = LocalContext.current

    DiseaseList(){
      diseaseTypeState = it
    }
  }
}
