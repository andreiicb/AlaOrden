package com.example.comandas.data.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.comandas.data.local.Food
import com.example.comandas.databinding.ItemFoodBinding

class FoodViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val binding = ItemFoodBinding.bind(view)

    fun render(FoodModel: Food, onClickListener: (Food) -> Unit) {
        binding.txtFoodname.text = FoodModel.FoodName
        binding.txtFoodprice.text = "$" + FoodModel.Price.toString()
        binding.imgFood.setImageResource(FoodModel.photo)

        itemView.setOnClickListener{onClickListener(FoodModel)}
    }
}

