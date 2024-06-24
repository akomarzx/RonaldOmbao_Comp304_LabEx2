package com.example.excercise1.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.excercise1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonMainEnter.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, HomeTypesActivity::class.java)
        startActivity(intent)
    }

}