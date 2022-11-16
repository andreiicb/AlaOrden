package com.example.comandas.ui.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log.i
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comandas.R
import com.example.comandas.data.adapter.FoodAdapter
import com.example.comandas.data.local.Food
import com.example.comandas.data.local.FoodProvider
import com.example.comandas.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null   //BINDING - LLAMAR ELEMENTOS XML MAS FACIL
    private val binding get() = _binding!!

    val args: SecondFragmentArgs by navArgs()  //pasar datos - primero declarar argumentos en el graph
    private var name: String? = ""
    private var menu_location: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
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

        menuLocation()

        toolbarActions(view)

        name = args.nombre
        val texto = "Hola $name, este es el fragment2"
        //Toast.makeText(activity, texto, Toast.LENGTH_SHORT).show()

    }

    private fun initFoodRecyclerViewer() {  //funcion de iniciar el recycler
        val manager = LinearLayoutManager(requireContext())
        binding.rvMenu.layoutManager = manager
        binding.rvMenu.adapter =
            FoodAdapter(FoodProvider.FoodList) { food ->
                onItemSelected(food)
            }
    }

    private fun initDrinkRecyclerViewer() {  //funcion de iniciar el recycler
        val manager = LinearLayoutManager(requireContext())
        binding.rvMenu.layoutManager = manager
        binding.rvMenu.adapter =
            FoodAdapter(FoodProvider.DrinkList) { food ->
                onItemSelected(food)
            }
    }

    private fun initAppetizerRecyclerViewer() {  //funcion de iniciar el recycler
        val manager = LinearLayoutManager(requireContext())
        binding.rvMenu.layoutManager = manager
        binding.rvMenu.adapter =
            FoodAdapter(FoodProvider.AppetizerList) { food ->
                onItemSelected(food)
            }
    }

    private fun onItemSelected(food: Food) { //food es el item del rv
        val foodNameDetails = food.FoodName
        val foodPriceDetails = food.Price //arguments del fragment al que seran enviados
        val foodImgDetails = food.photo
        val foodOverviewDetails = food.Overview
        val uri =
            Uri.parse("comandas://details/$foodNameDetails/$foodPriceDetails/$foodImgDetails/$foodOverviewDetails")
        findNavController().navigate(uri) //asignar los arguments del deep link en el nav graph

    }

    private fun toolbarActions(view: View) { //iniar rv dependiendo el menu que seleccionemos
        val toolbar = binding.myToolbar
        toolbar.inflateMenu(R.menu.menu_fragment2)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.drinks_menu -> {
                    toolbar.title = "BEBIDAS"
                    initDrinkRecyclerViewer()
                    true
                }
                R.id.food_menu -> {
                    toolbar.title = "COMIDAS"
                    initFoodRecyclerViewer()
                    true
                }
                R.id.appetizer_menu -> {
                    toolbar.title = "ENTRADAS"
                    initAppetizerRecyclerViewer()
                    true
                }
                else -> {
                    false
                }
            }
        }
        toolbar.setNavigationIcon(R.drawable.ic_back) //icon to navigate

        toolbar.setNavigationOnClickListener {
            logoutAccount(view)
        }
    }

    private fun logoutAccount(view: View) { //dialog de cerrar sesión

        val builder = AlertDialog.Builder(view.context)

        builder.setIcon(R.drawable.ic_exit)
        builder.setTitle("Cerrar sesión")
        builder.setPositiveButton("SI") { _, _ ->
            findNavController().navigate(Uri.parse("comandas://login"))
        }
        builder.setNegativeButton("NO") { _, _ -> }

        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun menuLocation() { //dependiendo el argument del navgraph, iniciar rv
        menu_location = args.menuLocation
        val toolbar = binding.myToolbar //toolbar para modificar su titulo
        when (menu_location) {
            "food" -> {
                initFoodRecyclerViewer()
                toolbar.title = "COMIDAS"
            }
            "drinks" -> {
                initDrinkRecyclerViewer()
                toolbar.title = "BEBIDAS"
            }
            "appetizer" -> {
                initAppetizerRecyclerViewer()
                toolbar.title = "ENTRADAS"
            }
        }
    }
}
