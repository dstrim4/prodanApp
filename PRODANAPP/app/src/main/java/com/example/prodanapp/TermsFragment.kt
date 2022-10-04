package com.example.prodanapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.prodanapp.databinding.FragmentTermsBinding

class TermsFragment : DialogFragment() {
    private var _binding: FragmentTermsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTermsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.acceptButtonTerms.setOnClickListener{
            if (binding.checkTerms.isChecked){
                val preferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
                with(preferences.edit()){
                    putBoolean("aviso", true)
                    apply()
                    dismiss()
                }
            }
        }
    }
}