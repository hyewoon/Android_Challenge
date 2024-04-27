package com.example.a04withrecyclerview.adapter

import android.database.DatabaseUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a04withrecyclerview.R
import com.example.a04withrecyclerview.databinding.TextRowItemBinding
import com.example.a04withrecyclerview.model.Post

class CustomAdapter(private val dataSet : ArrayList<Post>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder(binding : TextRowItemBinding) : RecyclerView.ViewHolder(binding.root){
        val text : TextView = binding.myText

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)
        val view = DataBindingUtil.inflate<TextRowItemBinding>(LayoutInflater.from(parent.context), R.layout.text_row_item, parent,false)

        return MyViewHolder(view)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.text.text = dataSet[position].title
    }

    override fun getItemCount(): Int {

        return dataSet.size
    }

}