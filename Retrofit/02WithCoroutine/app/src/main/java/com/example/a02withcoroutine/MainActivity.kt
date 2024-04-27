package com.example.a02withcoroutine

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val goToSecond = findViewById<Button>(R.id.goToSecond)
        goToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java )
            startActivity(intent)
        }

      /*  Log.d("Test", "Start")
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("Test", "CoroutineScope Start")
            a()
            b()
            Log.d("Test", "CoroutineScope end")

        }
        Log.d("Test", "end")*/

    }

}
 suspend fun a(){
     //최대 2초
     delay(1000)
     Log.d("Test", "API1")
     delay(1000)
     Log.d("Test", "API2")
 }

 suspend fun b(){
     //최대 2초
     delay(1000)
     Log.d("Test", "BPI1")
     delay(1000)
     Log.d("Test", "BPI2")
 }