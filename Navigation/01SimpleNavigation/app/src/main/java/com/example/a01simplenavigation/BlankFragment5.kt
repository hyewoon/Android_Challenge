package com.example.a01simplenavigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.navigation.findNavController


class BlankFragment5 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //1. back 버튼 눌렀을 때 fragment5 -> framgent1로 이동
    override fun onAttach(context: Context) {
        super.onAttach(context)

     /*   val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.d("BlankFragment5", "pressed")
                view?.let {
                    Navigation.findNavController(it).navigate(R.id.action_blankFragment5_to_blankFragment1)
                }

            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ):  View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank5, container, false)

        view.findViewById<Button>(R.id.btn5).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_blankFragment1_to_blankFragment2)
        }

        return view
    }

}