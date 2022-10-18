package com.example.prodanapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.prodanapp.data.Api
import com.example.prodanapp.data.RetrofitHelper
import com.example.prodanapp.databinding.FragmentRegisterBinding
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.confirmButtonRegister.setOnClickListener{
            var registerRequest = RegisterRequest(binding.emailInputRegister.text.toString(),
                binding.passwordInputRegister.text.toString(),
                binding.userInputRegister.text.toString())

            var retrofit = RetrofitHelper.getInstance().create(Api :: class.java)
            lifecycleScope.launch {
                val registerResponse = retrofit.postRegister(registerRequest)
                if(registerResponse.isSuccessful) {
                    findNavController().navigate(R.id.action_registerFragment_to_formFragment)
                }
                else{
                    binding.errorRegister.visibility = View.VISIBLE
                }
            }
        }

        binding.loginButtonRegister.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

    }

}