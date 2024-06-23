package com.example.excercise1.fragment

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.excercise1.data.HouseInformation
import com.example.excercise1.databinding.FragmentHouseListItemBinding

/**
 */
class MyHouseItemRecyclerViewAdapter(
    private val values: List<HouseInformation>
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
        holder.idView.text = item.address
        holder.contentView.text = item.price
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentHouseListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}