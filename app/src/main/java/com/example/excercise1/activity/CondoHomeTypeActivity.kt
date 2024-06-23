package com.example.excercise1.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.excercise1.fragment.HomeTypeToolBarFragment
import com.example.excercise1.R
import com.example.excercise1.data.HouseType
import com.example.excercise1.fragment.HouseListFragment

class CondoHomeTypeActivity : AppCompatActivity() {

    public var houseType : HouseType = HouseType.Condo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_condo_home_type)
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
        homeTypeToolbarBundle.putString("title", getString(R.string.home_menu_condominium_apartment))
        homeTypeToolBarFragment.arguments = homeTypeToolbarBundle

        // Add HomeTypeToolBarFragment to fragmentContainerView
        mFragmentTransaction.add(R.id.fragmentContainerView, homeTypeToolBarFragment)

        // Create HouseListFragment and set arguments
        val houseListFragment = HouseListFragment()
        val houseListBundle = Bundle()
        houseListBundle.putString("type", HouseType.Condo.name)
        houseListFragment.arguments = houseListBundle

        // Replace fragmentContainer_house_list with HouseListFragment
        mFragmentTransaction.replace(R.id.fragmentContainer_house_list, houseListFragment)

        // Commit the transaction
        mFragmentTransaction.commit()

    }
}