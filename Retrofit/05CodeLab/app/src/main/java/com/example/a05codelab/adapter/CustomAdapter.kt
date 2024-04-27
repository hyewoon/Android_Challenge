package com.example.a05codelab.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a05codelab.R
import com.example.a05codelab.model.Plant

class CustomAdapter(val context : Context,  val dataSet : List<Plant>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
    /*    val textArea : TextView
        val imageArea : ImageView

        init {
            textArea = view.findViewById(R.id.textArea)
            imageArea = view.findViewById(R.id.imageArea)
        }*/

        val textArea : TextView =view.findViewById(R.id.textArea)
        val imageArea : ImageView = view.findViewById(R.id.imageArea)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)

        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textArea.text = dataSet[position].name
        Glide.with(context).load(dataSet[position].imageUrl).into(holder.imageArea)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}