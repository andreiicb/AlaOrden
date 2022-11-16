package com.example.comandas.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.comandas.R
import com.example.comandas.data.local.Food
import com.example.comandas.data.local.FoodProvider.Companion.FoodList
import com.example.comandas.ui.fragments.details.FoodDetailsFragment

class FoodAdapter(private val FoodList: List<Food>, private val onClickListener: (Food) -> Unit) : RecyclerView.Adapter<FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context) //siempre poner esto
        return FoodViewHolder(layoutInflater.inflate(R.layout.item_food, parent, false))
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = FoodList[position]
        holder.render(item, onClickListener)

    }

    override fun getItemCount(): Int = FoodList.size
}