package com.eugene_dolgushev.dates

import androidx.multidex.MultiDexApplication

class MainApp : MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()
        ApplicationDICompanion.init(this)
    }
}