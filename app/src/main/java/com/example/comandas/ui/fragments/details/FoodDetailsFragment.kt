package com.example.comandas.ui.fragments.details

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavArgs
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.comandas.R
import com.example.comandas.data.local.Food
import com.example.comandas.data.local.FoodProvider
import com.example.comandas.databinding.FragmentFoodDetailsBinding

class FoodDetailsFragment : Fragment() {

    private var _binding: FragmentFoodDetailsBinding? = null
    private val binding get() = _binding!!

    val args: FoodDetailsFragmentArgs by navArgs() //pasar datos del otro fragment
    var foodname: String? = ""  //donde almacenaremos los argumentos del nav
    var foodprice: String? = "$"
    var foodoverview: String? = ""
    var foodimage: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onAttach(context: Context) { //block back press buttom
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Leave empty do disable back press or
                    // write your code which you want
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getFoodData()
        toolbarActions()

    }

    private fun getFoodData() {
        foodname =
            args.foodNameDetails.toString()  //asignamos el valor de la variable del otro fragment
        binding.nombreComida.text =
            foodname //esa variable se la daremos al elemento de nuestra view

        foodprice += args.foodPriceDetails.toString()
        binding.precioComida.text = foodprice

        foodoverview = args.foodOverviewDetails.toString()
        binding.descripcionComida.text = foodoverview

        foodimage = args.foodImgDetails
        binding.imgDetails.setImageResource(foodimage)
    }

    private fun toolbarActions() {
        val toolbar = binding.myToolbar
        toolbar.setNavigationIcon(R.drawable.ic_back) //icon to navigate
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
            exactMenuNavigation()

        }
    }

    private fun exactMenuNavigation() { //verificar si la lista que pasemos es donde estaba el item
        for (i in FoodProvider.FoodList) {
            if (i.FoodName == foodname) {
                findNavController().navigate(Uri.parse("comandas://menu/food"))
            } else continue
        }
        for (i in FoodProvider.DrinkList) {
                if (i.FoodName == foodname) {
                    findNavController().navigate(Uri.parse("comandas://menu/drinks"))
                }else continue
        }
        for (i in FoodProvider.AppetizerList) {
            if (i.FoodName == foodname) {
                findNavController().navigate(Uri.parse("comandas://menu/appetizer"))
            }else continue
        }
    }
}



