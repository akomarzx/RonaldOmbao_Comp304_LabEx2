package com.example.excercise1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.excercise1.R
import com.google.android.material.appbar.MaterialToolbar

class HomeTypeToolBarFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_home_type_tool_bar, container, false)
        val materialToolbar : MaterialToolbar? = view?.findViewById(R.id.material_toolbar_home_type)
        materialToolbar?.title = arguments?.getString("title")
        (activity as AppCompatActivity?)!!.setSupportActionBar(materialToolbar)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return view
    }

}