package com.example.mc2024

import android.app.Application

class MCApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)

    }
}