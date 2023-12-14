package com.example.healthanalyzertracker.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthanalyzertracker.models.ApiResult
import com.example.healthanalyzertracker.models.Cancer
import com.example.healthanalyzertracker.models.Diabetes
import com.example.healthanalyzertracker.models.Fetal
import com.example.healthanalyzertracker.models.Heart
import com.example.healthanalyzertracker.models.Liver
import com.example.healthanalyzertracker.utils.ApiResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BaseViewModel() : ViewModel() {

  private val _heartState = MutableStateFlow<ApiResponse<ApiResult>>(ApiResponse.Loading())
  val heartState = _heartState.asStateFlow()
  private val _liverState = MutableStateFlow<ApiResponse<ApiResult>>(ApiResponse.Loading())
  val liverState = _liverState.asStateFlow()
  private val _diabetesState = MutableStateFlow<ApiResponse<ApiResult>>(ApiResponse.Loading())
  val diabetesState = _diabetesState.asStateFlow()
  private val _fetalState = MutableStateFlow<ApiResponse<ApiResult>>(ApiResponse.Loading())
  val fetalState = _fetalState.asStateFlow()
  private val _cancerState = MutableStateFlow<ApiResponse<ApiResult>>(ApiResponse.Loading())
  val cancerState = _cancerState.asStateFlow()

  fun getHeartResult(data: Heart) {
    viewModelScope.launch {
      //todo network call
    }
  }

  fun getDiabetesResult(data: Diabetes) {
    viewModelScope.launch {
      //todo network call
    }
  }

  fun getCancerResult(data: Cancer) {
    viewModelScope.launch {
      //todo network call
    }
  }

  fun getLiverResult(data: Liver) {
    viewModelScope.launch {
      //todo network call
    }
  }

  fun getFetalResult(data: Fetal) {
    viewModelScope.launch {
      //todo network call
    }
  }
}