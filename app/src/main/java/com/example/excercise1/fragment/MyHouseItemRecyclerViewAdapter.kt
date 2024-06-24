package com.example.excercise1.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Trace
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.excercise1.data.HouseInformation
import com.example.excercise1.databinding.FragmentHouseListItemBinding


/**
 */
class MyHouseItemRecyclerViewAdapter(
    private val values: List<HouseInformation>,
    private val context : Context
) : RecyclerView.Adapter<MyHouseItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentHouseListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.addressText.text = item.address
        holder.contentImage.setImageResource(item.imgResID)
        holder.priceText.text = item.price
        holder.checkboxSelect.isChecked = false

        val sharedPreferences: SharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)

        if (sharedPreferences.contains("selected_items")) {
            // Preference does not exist, so add it
            val currentSet: MutableSet<String>? = sharedPreferences.getStringSet("selected_items", HashSet<String>())
            if(currentSet?.contains(item.homeId.toString()) == true) {
                holder.checkboxSelect.isChecked = true
            }
        }

        holder.checkboxSelect.setOnCheckedChangeListener { _, isChecked ->
            run {
                val editor = sharedPreferences.edit()

                if (!sharedPreferences.contains("selected_items")) {
                    // Preference does not exist, so add it
                    val defaultSet: Set<String> = HashSet()
                    editor.putStringSet("selected_items", defaultSet)
                }

                val currentSet: MutableSet<String>? = sharedPreferences.getStringSet("selected_items", HashSet<String>())
                val updateSet: HashSet<String>? = currentSet?.let { HashSet(it) }

                if(isChecked) {
                    updateSet?.add(item.homeId.toString())
                    editor.putStringSet("selected_items", updateSet)
                    editor.apply()
                } else {
                    if(updateSet?.contains(item.homeId.toString()) == true) {
                        updateSet.remove(item.homeId.toString())
                        editor.putStringSet("selected_items", updateSet)
                        editor.apply()
                    }
                }

            }
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentHouseListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var addressText = binding.textAddress
        val contentImage: ImageView = binding.imageLogo
        val checkboxSelect : CheckBox = binding.checkboxSelected
        val priceText : TextView = binding.textPrice
        override fun toString(): String {
            return super.toString()
        }

    }

}