package com.example.a01recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.a01recyclerview.databinding.ActivityMainBinding
import com.example.a01recyclerview.databinding.TextRowItemBinding
import org.w3c.dom.Text

//1. RecyclerView.Adapter클래스를 상속받는 커스텀 MyAapter를 만든다. 이때 3가지의 메소드도 같이 상속받는다.(overide)
class MyAdapter(private val dataSet: Array<String>, private val listener : OnItemClickListener) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    interface OnItemClickListener { //클릭이벤트 윈한 인터페이스 추가
        fun onItemClick( position: Int)
    }


    //2. viewHolder 만들기 MyViewHolder는 RecyclerView클래스.ViewHdler를 상속받는다.
    //3. viewbinding 적용한 경우: 여기서 TextRowItemBinding은 recyclerviewItem이다.
    //4.  여기에서 클릭이벤트 처리한다.
    class MyViewHolder(val binding : TextRowItemBinding, listener: OnItemClickListener): RecyclerView.ViewHolder(binding.root) {

        // Define click listener for the ViewHolder's View
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition

                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick( position)
                }
            }

        }
    }

  //create new views 여기서 뷰를 인플레이트해준다.onBindViewHolder(): RecyclerView calls this method
    // to associate a ViewHolder with data. The method fetches the appropriate data and uses the data to fill in the view holder's layout.
    // For example, if the RecyclerView displays a list of names, the method might find the appropriate name in the list and fill in the view holder's TextView widget.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val bindings =
            TextRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(bindings, listener )
    }
    // Replace the contents of a view (invoked by the layout manager)
     override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.binding.flowerName.text = dataSet[position]
     }
    //리사이클러뷰의 사이즈 반환
     override fun getItemCount(): Int = dataSet.size


 }