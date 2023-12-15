package com.example.healthanalyzertracker

import android.app.Application
import android.content.Context

class MyApp: Application() {
  override fun onCreate() {
    super.onCreate()
    appCtx = this
  }

  companion object {
    lateinit var appCtx : Context
  }
}