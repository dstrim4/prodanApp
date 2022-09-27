package com.example.prodanapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.prodanapp.databinding.FragmentLoginBinding

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
        binding.buttonConfirmLogin.setOnClickListener{
            //Check credentials
            val goTo = MainviewFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, goTo)
            transaction.commit()

        }

        binding.buttonGoToRegister.setOnClickListener{
            val goTo = RegisterFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, goTo)
            transaction.commit()
        }
    }
}