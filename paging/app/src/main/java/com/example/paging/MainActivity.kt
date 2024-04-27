package com.example.paging

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch


//repository vs storage
//요청 : MainActivity -> viewModel -> pagerSource-> Resository(네트워크)응답 -> adapter(UI)
class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel= ViewModelProvider(this)[MainViewModel::class.java]

        val rv = findViewById<RecyclerView>(R.id.rv)
        val myAdapter = MyAdapter()
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter =myAdapter

        //activity 라이프 사이클
        lifecycleScope.launch {
            viewModel.items.collect{
                myAdapter.submitData(it)
            }
        }

    }
}