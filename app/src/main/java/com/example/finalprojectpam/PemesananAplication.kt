package com.example.finalprojectpam

import android.app.Application
import com.example.finalprojectpam.data.AppContainer
import com.example.finalprojectpam.data.KontainerPemesanan

class PemesananAplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        container= KontainerPemesanan()
    }
}