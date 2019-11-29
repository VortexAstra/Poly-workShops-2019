package com.university.workshop3

import android.app.Application
import android.util.Log

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        Log.d("MainApplication", "onTerminate called")
        super.onTerminate()
    }
}
