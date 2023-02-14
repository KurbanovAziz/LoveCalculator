package com.example.lovecalculator.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.remote.LoveModel


@Dao
interface LoveDao {

   @Insert
    fun insert(loveModel: List<LoveModel>)

    @Query("SELECT * FROM 'LOVE_HISTORY'")
    fun getAll(): List<LoveModel>

    @Query("SELECT * FROM 'LOVE_HISTORY' ORDER BY firstName ASC")
    fun getAllAtoZ():LiveData<List<LoveModel>>
}