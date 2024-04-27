package com.example.a01recyclerview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.a01recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dataSet = arrayOf("sunFlower", "peach", "Mocha", "News")
        val myAdapter = MyAdapter(dataSet, this)

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.adapter = myAdapter

}

    //position 가져오기 ok
    //입력된 값 가져오기 : sunFlower 가져오기
        override fun onItemClick(position: Int) {

       Toast.makeText(this,position.toString(),Toast.LENGTH_LONG ).show()
    }
}