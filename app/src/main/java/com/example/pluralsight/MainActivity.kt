package com.example.pluralsight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pluralsight.api.QuoteService
import com.example.pluralsight.api.RetrofitHelper
import com.example.pluralsight.repository.QuoteRepository
import com.example.pluralsight.rvadapter.RVAdapter
import com.example.pluralsight.viewmodels.MainViewModel
import com.example.pluralsight.viewmodels.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMVVM.setHasFixedSize(true)
        rvMVVM.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            mainViewModel.quotes.observe(this)  {
                var myadapter = RVAdapter(this, it.results)
                rvMVVM.adapter = myadapter
                Toast.makeText(this, it.results.size.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        val repository = (application as QuoteApplication).quoteRepository

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)



    }
}