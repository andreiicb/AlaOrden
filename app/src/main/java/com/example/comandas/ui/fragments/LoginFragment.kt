package com.example.comandas.ui.fragments

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.comandas.databinding.FragmentLoginBinding
import kotlinx.coroutines.delay

class LoginFragment : Fragment() {

    //BINDING - LLAMAR ELEMENTOS DEL XML MAS FACIL

    private var _binding: FragmentLoginBinding? = null //crear variable nula porque no sabemos si va haber contenido o no
    private val binding get() = _binding!! //llamamos a la variable y aseguramos que no es nulo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)  //inflar layout
        return binding.root //binding actualizado

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        validar_contraseña()

    }

    lateinit var usuario:String
    lateinit var contraseña:String

    private fun validar_contraseña() {

            val login = binding.btnLogin

            login.setOnClickListener {

                contraseña= binding.textfieldPassword.editText?.text.toString()

                Log.d("Contraseña","escribiste $contraseña")

                if (contraseña == "") {

                    navigation()

                }else{ Toast.makeText(context, "Contraseña incorrecta", Toast.LENGTH_SHORT).show() }
            }

    }

    private fun navigation(){  //pasar de fragments con datos
        usuario = binding.textfieldUsuario.editText?.text.toString()
        val action = LoginFragmentDirections.actionLoginFragmentToSecondFragment("food",usuario)//cambiar de pantalla
        findNavController().navigate(action)  //Implementar plugins safeargs para generar directions

    }

}