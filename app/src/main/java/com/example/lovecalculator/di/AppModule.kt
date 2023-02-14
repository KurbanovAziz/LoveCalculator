package com.example.lovecalculator.di

import android.content.Context
import androidx.room.Room
import com.example.lovecalculator.room.local.Pref
import com.example.lovecalculator.remote.LoveApi
import com.example.lovecalculator.room.local.AppDataBase
import com.example.lovecalculator.room.local.LoveDao
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

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context:Context): AppDataBase {
        return  Room.databaseBuilder(context, AppDataBase::class.java, "love_data")
            .allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun provideHistoryDao(@ApplicationContext context: Context): LoveDao {
        return provideDataBase(context).loveDao()
    }


}