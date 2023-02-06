package com.example.lovecalculator

import android.content.Context
import android.content.SharedPreferences
import com.google.android.material.shadow.ShadowRenderer

class Pref(private val context: Context) {

    private val pref : SharedPreferences  = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveState(){
        pref.edit().putBoolean(ON_BOARDING_SING,true).apply()
    }
    fun isShown():Boolean{
        return pref.getBoolean(ON_BOARDING_SING,false)

    }


    companion object{

        private const val PREF_NAME = "pref_task_manager"
        private const val ON_BOARDING_SING = "is_seen"
    }
}