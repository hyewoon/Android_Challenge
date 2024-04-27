package com.example.a05codelab

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a05codelab.adapter.CustomAdapter
import com.example.a05codelab.viewModel.MainViewModel

// https://raw.githubusercontent.com/googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 1.viewModel 연결
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // 2. 데이터 받아오기
        viewModel.getAllData()

        val rv = findViewById<RecyclerView>(R.id.rv)

        //3. viewModel의 result 값이 변경되면 그걸 관찰해서 recyclerview 에 넣어준다.
       viewModel.result.observe(this, Observer {

           val customAdapter = CustomAdapter(this, it)
           rv.adapter = customAdapter
           rv.layoutManager = LinearLayoutManager(this)
       })
    }
}