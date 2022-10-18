package com.example.prodanapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.prodanapp.data.Api
import com.example.prodanapp.data.Constants
import com.example.prodanapp.data.RetrofitHelper
import com.example.prodanapp.databinding.FragmentLoginBinding
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.confirmButtonLogin.setOnClickListener{
            var authenticationRequest = AuthenticationRequest(binding.userInputLogin.text.toString(),
                                                              binding.passwordInputLogin.text.toString())

            var retrofit = RetrofitHelper.getInstance().create(Api :: class.java)

            lifecycleScope.launch{
                val authenticationResponse = retrofit.postAuthentication(authenticationRequest)
                if (authenticationResponse.isSuccessful){
                    Constants.API_TOKEN = authenticationResponse.body()?.jwt ?: String()
                    findNavController().navigate(R.id.action_loginFragment_to_mainviewFragment)
                }
                else{
                    binding.errorLogin.visibility = View.VISIBLE
                }
            }
        }

        binding.registerButtonLogin.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}