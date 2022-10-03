package com.example.prodanapp

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.prodanapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val navView: BottomNavigationView = binding.bottomNavigationView
//
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.contactFragment, R.id.mainviewFragment, R.id.formFragment
            )
        )

       // setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        hideBottomNav()

    }

    private fun hideBottomNav(){
        binding.bottomNavigationView.visibility = View.GONE
    }

    fun showBottomNav(){
        binding.bottomNavigationView.visibility = View.VISIBLE
    }
}