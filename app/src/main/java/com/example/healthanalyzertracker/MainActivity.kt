package com.example.healthanalyzertracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthanalyzertracker.ui.screens.CancerScreen
import com.example.healthanalyzertracker.ui.screens.DiabetesScreen
import com.example.healthanalyzertracker.ui.screens.FetalHealthScreen
import com.example.healthanalyzertracker.ui.screens.HeartScreen
import com.example.healthanalyzertracker.ui.screens.HomeScreen
import com.example.healthanalyzertracker.ui.screens.LiverScreen
import com.example.healthanalyzertracker.ui.screens.StrokeScreen
import com.example.healthanalyzertracker.ui.theme.HealthAnalyzerTrackerTheme
import com.example.healthanalyzertracker.utils.Constants.CANCER_SCREEN
import com.example.healthanalyzertracker.utils.Constants.DIABETES_SCREEN
import com.example.healthanalyzertracker.utils.Constants.FETAL_SCREEN
import com.example.healthanalyzertracker.utils.Constants.HEART_SCREEN
import com.example.healthanalyzertracker.utils.Constants.HOME_SCREEN
import com.example.healthanalyzertracker.utils.Constants.LIVER_SCREEN
import com.example.healthanalyzertracker.utils.Constants.STROKE_SCREEN
import com.example.healthanalyzertracker.utils.DiseaseType

class MainActivity : ComponentActivity() {

  private lateinit var navHostController: NavHostController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HealthAnalyzerTrackerTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          navHostController = rememberNavController()
          SetupNavigation(navHostController)
        }
      }
    }
  }
}

@Composable
fun SetupNavigation(navHostController: NavHostController) {
  NavHost(navHostController, startDestination = HOME_SCREEN) {
    composable(HOME_SCREEN) {
      HomeScreen()
      { type ->
        when (type) {
          DiseaseType.LIVER -> {
            navHostController.navigate(LIVER_SCREEN)
          }

          DiseaseType.FETAL_HEALTH -> {
            navHostController.navigate(FETAL_SCREEN)
          }

          DiseaseType.CANCER -> {
            navHostController.navigate(CANCER_SCREEN)
          }

          DiseaseType.HEART -> {
            navHostController.navigate(HEART_SCREEN)
          }

          DiseaseType.STROKE -> {
            navHostController.navigate(STROKE_SCREEN)
          }

          DiseaseType.DIABETES -> {
            navHostController.navigate(DIABETES_SCREEN)
          }
        }
      }
    }
    composable(LIVER_SCREEN) { LiverScreen() }
    composable(STROKE_SCREEN) { StrokeScreen() }
    composable(CANCER_SCREEN) { CancerScreen() }
    composable(FETAL_SCREEN) { FetalHealthScreen() }
    composable(HEART_SCREEN) { HeartScreen() }
    composable(DIABETES_SCREEN) { DiabetesScreen() }
  }
}
