package com.example.tripplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tripplanner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setupFAB()
        setContentView(_binding.root)
    }

    /*
    * Setup Fab
    */
    private fun setupFAB() {
        _binding.fab.setOnClickListener {
            AddEditTripFragment().show(supportFragmentManager, AddEditTripFragment.fragmentName)
        }
    }
}