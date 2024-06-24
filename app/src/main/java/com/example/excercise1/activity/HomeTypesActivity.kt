package com.example.excercise1.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.excercise1.R
import com.example.excercise1.data.HomeDataSource
import com.example.excercise1.data.HouseInformation
import com.google.android.material.appbar.MaterialToolbar


class HomeTypesActivity : AppCompatActivity() {

    private var currentSelected : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_types)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val checkoutButton : Button = findViewById(R.id.button_proceed_checkout)

        checkoutButton.setOnClickListener {
            if(currentSelected.isNotBlank()) {
                val intent = Intent(this, CheckoutHomeActivity::class.java)
                val bundle : Bundle = Bundle();
                bundle.putString("item", this.currentSelected)
                intent.putExtras(bundle);
                startActivity(intent)
            } else {
                val text = "Please Select the house that you want to checkout first."
                val duration = Toast.LENGTH_LONG
                val toast = Toast.makeText(this, text, duration) // in Activity
                toast.show()
            }
        }

        val materialToolbar : MaterialToolbar = findViewById(R.id.materialToolbar_home_menu)
        setSupportActionBar(materialToolbar)
        createRadioGroupFromSharedPreferences()
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

    private fun createRadioGroupFromSharedPreferences() {

        val sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val currentSelected = sharedPreferences.getStringSet("selected_items", emptySet()) ?: emptySet()
        val houseCollections = HomeDataSource.getHouses()
        val idToObjectMap  = houseCollections.associateBy { it.homeId }

        val radioGroup = findViewById<RadioGroup>(R.id.radio_group_selected)

        for (homeId  in currentSelected) {
            val obj : HouseInformation? = idToObjectMap[homeId.toInt()]
            if (obj != null) {
                val radioButton = RadioButton(this)
                radioButton.text = "${obj.address} - ${obj.price}"
                radioButton.tag = obj
                radioButton.setOnCheckedChangeListener { buttonView, isChecked ->
                    run {
                        this.currentSelected = buttonView.text.toString()
                    }
                }
                radioGroup.addView(radioButton)
            }
        }
    }

}