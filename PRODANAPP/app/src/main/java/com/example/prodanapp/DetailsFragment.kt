package com.example.prodanapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.prodanapp.data.Animal
import com.example.prodanapp.data.Sample
import com.example.prodanapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val animal = it.get("animal") as Animal

            binding.nameText.text = animal.name
            var text = animal.age
            text += if (animal.age == "1"){
                " año"
            } else{
                " años"
            }
            binding.ageTextDetails.text = text
            binding.raceTextDetails.text = animal.race
            binding.descriptionTextDetails.text = animal.description
            Glide.with(requireActivity())
                .load(animal.imgUrl)
                .into(binding.animalImageDetails)
        }


        binding.backButtonDetails.setOnClickListener{
            findNavController().navigate(R.id.action_detailsFragment_to_mainviewFragment)
        }

        binding.confirmButtonDetails.setOnClickListener{

//            var dialog = ConfirmationFragment()
            var dialog = GoogleFormFragment()
            dialog.show(parentFragmentManager, "customDialog")
            dialog.isCancelable = true
        }

    }
}