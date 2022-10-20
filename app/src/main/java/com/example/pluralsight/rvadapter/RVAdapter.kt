package com.example.pluralsight.rvadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.pluralsight.R
import com.example.pluralsight.models.QuoteList
import com.example.pluralsight.models.Result
import kotlinx.android.synthetic.main.cardview.view.*

class RVAdapter(val context: Context, val list: List<Result>) : RecyclerView.Adapter<RVAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var txtId: TextView = itemView.txtId
        var txtTitle1: TextView = itemView.txtTitle1
        var txtBody1: TextView = itemView.txtBody1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.txtId.text = list[position].toString()
        holder.txtTitle1.text = list[position].author
        holder.txtBody1.text = list[position].content
    }

    override fun getItemCount(): Int {
        return list.size
    }
}