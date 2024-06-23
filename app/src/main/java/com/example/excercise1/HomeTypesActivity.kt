package com.example.excercise1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar


class HomeTypesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_types)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val materialToolbar : MaterialToolbar = findViewById(R.id.materialToolbar_home_menu)
        setSupportActionBar(materialToolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.home_type_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.home_menu_apartment -> {
                val intent = Intent(this, ApartmentHomeTypeActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.home_menu_detached -> {
                val intent = Intent(this, DetachedHomeTypeActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.home_menu_semi_detached -> {
                val intent = Intent(this, SemiDetachedHomeTypeActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.home_menu_condominium_apartment -> {
                val intent = Intent(this, CondoHomeTypeActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.home_menu_townhouse -> {
                val intent = Intent(this, TownhouseHomeTypeActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}