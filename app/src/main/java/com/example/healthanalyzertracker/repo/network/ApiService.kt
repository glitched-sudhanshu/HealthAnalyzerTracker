package com.example.healthanalyzertracker.repo.network

import com.example.healthanalyzertracker.models.DiseasePredictionResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

  @POST("completions")
  suspend fun getDiseaseResult(@Body body: RequestBody): DiseasePredictionResponse

}