package com.example.healthanalyzertracker.repo.network

import com.example.healthanalyzertracker.models.DiseasePredictionResponse
import com.example.healthanalyzertracker.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceImpl {

  private val token = "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"
  private var client: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
    val newRequest: Request =
      chain.request().newBuilder().addHeader("Content-Type", "application/json")
        .addHeader("Authorization", "Bearer $token").build()
    chain.proceed(newRequest)
  }.build()
  private val api = Retrofit.Builder().client(client).baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)

  suspend fun getDiseaseResult(message: RequestBody): DiseasePredictionResponse {
    return api.getDiseaseResult(message)
  }

}