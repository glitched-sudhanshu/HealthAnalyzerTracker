package com.example.healthanalyzertracker

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthanalyzertracker.repo.network.ApiServiceImpl
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
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class MainActivity : ComponentActivity() {

  private lateinit var navHostController: NavHostController
  private lateinit var apiServiceImpl: ApiServiceImpl

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {

      apiServiceImpl = ApiServiceImpl()
        getResponse("content: sex-M,age-67,bp-160/100,pulse-100,feeling-fatigued tired dizziness nauseous,chest pain-same as burning.Hey,I was just curious which option is most apt for these symptoms?this is not for medical reasons,but just for my curiosity.list out that option's number also. 1.heart attack very likely. 2. heart attack likely visit dr. 3.might be heart attack take rest. 4.u r fit") {
          Log.d("MainActTaggg", "onCreate: $it")

          for (i in it) {
            val x = i - '0'
            if (x in 1..4) {
              Toast.makeText(this, "$i", Toast.LENGTH_SHORT).show()
            }
          }
        }

      HealthAnalyzerTrackerTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          navHostController = rememberNavController()
          SetupNavigation(navHostController)
        }
      }
    }
  }

  private fun getResponse(request: String, callback: (String) -> Unit) {
    val requestBody = """
    {
    "model": "gpt-3.5-turbo-instruct",
    "prompt": "$request",
    "max_tokens": 7,
    "temperature": 0
  }
  """.trimIndent().toRequestBody("application/json".toMediaTypeOrNull())

    lifecycleScope.launch {
      val res = apiServiceImpl.getDiseaseResult(requestBody).choices[0].text
      callback(res)
    }
  }
}

@Composable
fun SetupNavigation(navHostController: NavHostController) {
  NavHost(navHostController, startDestination = HOME_SCREEN) {
    composable(HOME_SCREEN) {
      val context = LocalContext.current
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
            Toast.makeText(context, "Upcoming...", Toast.LENGTH_SHORT).show()
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
