package com.example.a03withcoroutineviewmodesample

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a03withcoroutineviewmodesample.adapter.CustomAdapter
import com.example.a03withcoroutineviewmodesample.model.Post
import com.example.a03withcoroutineviewmodesample.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //1번, 4번 ,7번 순으로 받아지지 않는다. (7-> 1-> 4)
        viewModel.getPost()
        viewModel.getPostNumber(4)
        viewModel.getPostAll()


        val area1 = findViewById<TextView>(R.id.area1)
        val area2 = findViewById<TextView>(R.id.area2)

        viewModel.liveWord1.observe(this) {
            area1.text = it.toString()
        }

        viewModel.liveWord2.observe(this) {
            area2.text = it.toString()
        }

        val rv = findViewById<RecyclerView>(R.id.rv)

        viewModel.liveWordList.observe(this) {
            //recyclerView로 보여준다.

            val customAdapter = CustomAdapter(it as ArrayList<Post>)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)
        }
    }

}