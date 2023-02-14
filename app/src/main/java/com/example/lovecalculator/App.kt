package com.example.lovecalculator

import android.app.Application
import androidx.room.Room
import com.example.lovecalculator.room.local.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var db: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "love_data")
            .allowMainThreadQueries().build()
    }
}