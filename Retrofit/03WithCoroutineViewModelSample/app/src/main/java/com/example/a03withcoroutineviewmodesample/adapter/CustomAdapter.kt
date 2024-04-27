package com.example.a03withcoroutineviewmodesample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.a03withcoroutineviewmodesample.R
import com.example.a03withcoroutineviewmodesample.model.Post

class CustomAdapter(private val dataSet : ArrayList<Post>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){

    class MyViewHolder(view: View) : ViewHolder(view){

        val text : TextView

        init {
            text = view.findViewById(R.id.textViews)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)

        return MyViewHolder(view)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.text.text = dataSet[position].title
    }

    override fun getItemCount(): Int {
       return dataSet.size
    }
}