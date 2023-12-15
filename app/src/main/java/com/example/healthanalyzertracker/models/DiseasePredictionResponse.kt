package com.example.healthanalyzertracker.models

import com.google.gson.annotations.SerializedName

data class DiseasePredictionResponse(
  @SerializedName("choices")
  val choices: List<Choice>,
  @SerializedName("created")
  val created: Int,
  @SerializedName("id")
  val id: String,
  @SerializedName("model")
  val model: String,
  @SerializedName("object")
  val `object`: String,
  @SerializedName("usage")
  val usage: Usage
)

data class Usage(
  val completion_tokens: Int,
  val prompt_tokens: Int,
  val total_tokens: Int
)

data class Message(
  val content: String,
  val role: String
)

data class Choice(
  val finish_reason: String,
  val index: Int,
  val message: Message
)
