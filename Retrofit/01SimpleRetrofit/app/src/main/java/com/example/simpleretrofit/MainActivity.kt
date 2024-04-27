package com.example.simpleretrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val manager  =supportFragmentManager

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //기존의 방식
        //binding.myText.text = "바뀐텍스트"

        //데이터 결합
        val person = Person("텍스트", 20)
        binding.user = person



        //api가져오기(순서 생각해서)
        //1. 유저아이디 가져오기
        val api = RetrofitInstance.getInstance().create(MyApi::class.java)


        api.getPost1().enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API1", response.body().toString())
                //2. 유저 아이디통해 닉네임
                api.getPostNumber(2).enqueue(object : Callback<Post> {
                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
                        Log.d("API2", response.body().toString())
                        //3. 그 닉네임 댓글
                        api.getPostNumber(3).enqueue(object : Callback<Post> {
                            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                                Log.d("API3", response.body().toString())
                                //4. 거기 대댓글
                                api.getPostNumber(4).enqueue(object : Callback<Post> {
                                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
                                        Log.d("API4", response.body().toString())
                                    }

                                    override fun onFailure(call: Call<Post>, t: Throwable) {
                                        Log.d("API4", "Error: " + t.message)
                                    }


                                })

                            }

                            override fun onFailure(call: Call<Post>, t: Throwable) {
                                Log.d("API3", "Error: " + t.message)
                            }


                        })
                    }

                    override fun onFailure(call: Call<Post>, t: Throwable) {
                        Log.d("API2", "Error: " + t.message)
                    }


                })

            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API1", "Error: " + t.message)
            }


        })


        //4. 거기 대댓글
        api.getPostNumber(4).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API4", response.body().toString())
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API4", "Error: " + t.message)
            }


        })
    }

}



