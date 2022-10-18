package com.example.prodanapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.prodanapp.databinding.FragmentFormBinding

class FormFragment : Fragment() {

    private var _binding: FragmentFormBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).showBottomNav()

        val preferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val aceptado = preferences.getBoolean("aviso", false)

        setPreferences()

        if (!aceptado){
            val dialog = TermsFragment()

            dialog.show(parentFragmentManager, "customDialog")
            dialog.isCancelable = false
        }



        binding.confirmButtonForm.setOnClickListener{
            savePreferences()
//            findNavController().navigate(R.id.action_formFragment_to_mainviewFragment)
        }
    }

    private fun savePreferences(){
        val preferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        with(preferences.edit()){
            putBoolean("pregunta1", binding.q1Form.isChecked)
            putBoolean("pregunta2", binding.q2Form.isChecked)
            putBoolean("pregunta3", binding.q3Form.isChecked)
            putBoolean("pregunta4", binding.q4Form.isChecked)
            commit()
        }
    }

    private fun setPreferences(){
        val preferences = requireActivity().getPreferences(Context.MODE_PRIVATE)


        binding.q1Form.isChecked = preferences.getBoolean("pregunta1", false)
        binding.q2Form.isChecked = preferences.getBoolean("pregunta2", false)
        binding.q3Form.isChecked = preferences.getBoolean("pregunta3", false)
        binding.q4Form.isChecked = preferences.getBoolean("pregunta4", false)
    }

}