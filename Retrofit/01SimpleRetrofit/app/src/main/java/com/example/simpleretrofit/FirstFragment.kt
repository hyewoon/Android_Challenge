package com.example.simpleretrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.simpleretrofit.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        // Inflate the layout for this fragment
        binding.fragmentText.text = "fragmentDataBinding"

        return binding.root
    }


}