package com.example.prodanapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import com.example.prodanapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Start setup
        replaceFragment(LoginFragment())
        hideBottomNav()

        //Bottom Navigation listener
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.contact -> replaceFragment(ContactFragment())
                R.id.home -> replaceFragment(MainviewFragment())
                R.id.form -> replaceFragment(FormFragment())

                else -> {
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    fun hideBottomNav(){
        binding.bottomNavigationView.visibility = View.GONE
    }

    fun showBottomNav(){
        binding.bottomNavigationView.visibility = View.VISIBLE
    }
}