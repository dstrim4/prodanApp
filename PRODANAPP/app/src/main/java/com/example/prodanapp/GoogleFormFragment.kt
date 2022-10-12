package com.example.prodanapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.prodanapp.databinding.FragmentGoogleFormBinding

const val formsURL = "https://docs.google.com/forms/d/e/1FAIpQLSc9Nj7H1W5kaIEvD2gPP2nyQ1G4iKndw90BJWHs8_Maz6tADw/viewform"


class GoogleFormFragment : DialogFragment() {

    private var _binding: FragmentGoogleFormBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGoogleFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webview.settings.javaScriptEnabled = true
        binding.webview.loadUrl(formsURL)



    }
}