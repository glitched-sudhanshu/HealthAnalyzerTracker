package com.example.healthanalyzertracker.models

data class ApiResult(
  val result: Int
)

fun ApiResult.getString(): String {
  return when (result) {
    1 -> "Disease DETECTED! Contact a doctor ASAP!"
    2 -> "Disease might exist. Kindly consult a doctor!"
    3 -> "Disease may or may not exist, you should take rest or consult a physician"
    4 -> "Don't worry you are absolutely fine!"
    -1 -> "Some error occurred at backend!"
    -2 -> "Connection failed due to slow internet connectivity!"
    else -> "Unknown error occurred!"
  }
}