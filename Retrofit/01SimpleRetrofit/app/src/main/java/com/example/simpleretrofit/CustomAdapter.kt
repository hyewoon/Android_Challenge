package com.example.simpleretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.simpleretrofit.databinding.TextRowItemBinding

class CustomAdapter(private val dataSet : ArrayList<String>): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder(binding : TextRowItemBinding) : ViewHolder(binding.root){

        val rvText : TextView = binding.rvText

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      //  val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)

        val view = DataBindingUtil.inflate<TextRowItemBinding>(LayoutInflater.from(parent.context), R.layout.text_row_item, parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.rvText.text =dataSet[position]


    }

    override fun getItemCount(): Int {

        return dataSet.size
    }

}