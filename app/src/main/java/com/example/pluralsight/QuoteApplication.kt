package com.example.pluralsight

import android.app.Application
import com.example.pluralsight.api.QuoteService
import com.example.pluralsight.api.RetrofitHelper
import com.example.pluralsight.db.QuoteDatabase
import com.example.pluralsight.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize(){
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}