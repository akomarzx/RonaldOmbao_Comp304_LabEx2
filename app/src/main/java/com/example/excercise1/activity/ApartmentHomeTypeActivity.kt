package com.example.excercise1.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import com.example.excercise1.fragment.HomeTypeToolBarFragment
import com.example.excercise1.R
import com.example.excercise1.data.HomeDataSource
import com.example.excercise1.data.HouseInformation
import com.example.excercise1.data.HouseType
import com.example.excercise1.fragment.HouseListFragment
import kotlin.collections.ArrayList

class ApartmentHomeTypeActivity : AppCompatActivity() {

    public var houseType : HouseType = HouseType.Apartment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_apartment_home_type)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()

        // Create HomeTypeToolBarFragment and set arguments
        val homeTypeToolBarFragment = HomeTypeToolBarFragment()
        val homeTypeToolbarBundle = Bundle()
        homeTypeToolbarBundle.putString("title", getString(R.string.home_menu_apartment))
        homeTypeToolBarFragment.arguments = homeTypeToolbarBundle

        // Add HomeTypeToolBarFragment to fragmentContainerView
        mFragmentTransaction.add(R.id.fragmentContainerView, homeTypeToolBarFragment)

        // Create HouseListFragment and set arguments
        val houseListFragment = HouseListFragment()
        val houseListBundle = Bundle()
        houseListBundle.putString("type", HouseType.Apartment.name)
        houseListFragment.arguments = houseListBundle

        // Replace fragmentContainer_house_list with HouseListFragment
        mFragmentTransaction.replace(R.id.fragmentContainer_house_list, houseListFragment)

        // Commit the transaction
        mFragmentTransaction.commit()
    }
}