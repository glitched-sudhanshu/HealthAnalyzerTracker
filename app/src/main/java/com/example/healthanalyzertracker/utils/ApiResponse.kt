package com.example.healthanalyzertracker.utils

sealed class ApiResponse<T> {
  class Loading<T> : ApiResponse<T>()
  data class Success<T>(val data: T) : ApiResponse<T>()
  data class Error<T>(val message: String = "Unexpected Error") : ApiResponse<T>()
}