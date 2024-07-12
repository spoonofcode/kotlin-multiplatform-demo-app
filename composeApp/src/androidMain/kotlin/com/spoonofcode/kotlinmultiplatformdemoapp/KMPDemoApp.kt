package com.spoonofcode.kotlinmultiplatformdemoapp

import KoinInitializer
import android.app.Application

class KMPDemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}