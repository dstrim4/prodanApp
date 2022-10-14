package com.example.prodanapp

import InfiniteRecyclerAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.prodanapp.data.Api
import com.example.prodanapp.data.RetrofitHelper
import com.example.prodanapp.data.Sample
import com.example.prodanapp.databinding.FragmentMainviewBinding
import kotlinx.coroutines.launch


class MainviewFragment : Fragment() {

    private var _binding: FragmentMainviewBinding? = null
    private val binding get() = _binding!!

    private lateinit var infiniteViewPager: ViewPager2
    private lateinit var infiniteRecyclerAdapter: InfiniteRecyclerAdapter

    private var sampleList: MutableList<Sample> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).showBottomNav()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainviewBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //getting the required sample data for filling the ViewPager
//        getSampleData()

        val retrofit = RetrofitHelper.getInstance().create(Api :: class.java)

        lifecycleScope.launch{
            val datos = retrofit.getAnimals()

            for (item in datos.body()?.data!!){
                sampleList.add(item.sample)
            }

            // setting up the infinite ViewPager
            infiniteViewPager = binding.infiniteViewPager
            infiniteRecyclerAdapter = InfiniteRecyclerAdapter(sampleList){
                val bundle = Bundle()
                bundle.putParcelable("sample", it)
                findNavController().navigate(R.id.action_mainviewFragment_to_detailsFragment, bundle)
            }
            infiniteViewPager.adapter = infiniteRecyclerAdapter

            infiniteRecyclerAdapter.setOnItemClickListener(object : InfiniteRecyclerAdapter.onItemCLickListener{
                override fun onItemClick(position: Int) {
                    findNavController().navigate(R.id.action_mainviewFragment_to_detailsFragment)
                }
            })

            // setting the current item of the infinite ViewPager to the actual first element
            infiniteViewPager.currentItem = 1

            // function for registering a callback to update the ViewPager
            // and provide a smooth flow for infinite scroll
            onInfinitePageChangeCallback(sampleList.size + 2)
        }
    }

//    private fun getSampleData() {
//        sampleList.add(Sample(1, "#91C555"))
//        sampleList.add(Sample(2, "#F48E37"))
//        sampleList.add(Sample(3, "#FF7B7B"))
//    }

    private fun onInfinitePageChangeCallback(listSize: Int) {
        infiniteViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    when (infiniteViewPager.currentItem) {
                        listSize - 1 -> infiniteViewPager.setCurrentItem(1, false)
                        0 -> infiniteViewPager.setCurrentItem(listSize - 2, false)
                    }
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position != 0 && position != listSize - 1) {
                    // pageIndicatorView.setSelected(position-1)
                }
            }
        })
    }
}