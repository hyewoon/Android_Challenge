package com.example.a04withrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a04withrecyclerview.adapter.CustomAdapter
import com.example.a04withrecyclerview.databinding.ActivityMainBinding
import com.example.a04withrecyclerview.model.Post
import com.example.a04withrecyclerview.viewModel.MyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var viewModel : MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        viewModel.getPostAll()

        //val rv = findViewById<RecyclerView>(R.id.rv)

        viewModel.liveWordList.observe(this){

            val customAdapter = CustomAdapter(it as ArrayList<Post>)
            binding.rv.adapter = customAdapter
            binding.rv.layoutManager = LinearLayoutManager(this)

        }

    }
}