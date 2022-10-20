package com.example.pluralsight.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pluralsight.models.Result

@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuotes(quotes: List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes() : List<Result>
}