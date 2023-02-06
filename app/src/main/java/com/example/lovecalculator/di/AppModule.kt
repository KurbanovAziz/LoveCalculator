package com.example.lovecalculator.di

import android.content.Context
import com.example.lovecalculator.Pref
import com.example.lovecalculator.remote.LoveApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule() {


    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create(Gson())).build()
            .create(LoveApi::class.java)
    }

    @Singleton
    @Provides
    fun providePrefs(@ApplicationContext context: Context): Pref {
        return Pref(context)
    }


}