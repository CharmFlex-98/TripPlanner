package com.example.tripplanner.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.tripplanner.application.TripApplication
import com.example.tripplanner.databinding.ActivityMainBinding
import com.example.tripplanner.ui.new_edit.AddEditTripFragment
import com.example.tripplanner.utils.TripViewModelProviderFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var _binding: ActivityMainBinding
    private val _tripViewModel: TripViewModel by viewModels { TripViewModelProviderFactory { TripViewModel((application as TripApplication).tripRepository)} }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setupFAB()
        setupTripList()
        setContentView(_binding.root)
    }


    /*
    * Setup recycler view for trip list
    */
    private fun setupTripList() {
        _binding.tripRecyclerView.apply {
            adapter = TripListAdapter()
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                println("repeat on lifecycle")
                _tripViewModel.uiState.collect {
                    if (it.userMessage != null) {
                        toggleErrorMessage(it, true)
                    } else {
                        toggleErrorMessage(it, false)
                        (_binding.tripRecyclerView.adapter as? TripListAdapter)?.submitList(it.tripList)
                    }
                }
            }
        }
    }


    private fun toggleErrorMessage(uiState: TripListState, on: Boolean) {
        if (on) {
            _binding.loadTripListError.apply {
                text = uiState.userMessage
                visibility = View.VISIBLE
            }
            _binding.tripRecyclerView.visibility = View.GONE
        } else {
            _binding.loadTripListError.apply {
                visibility = View.GONE
            }
            _binding.tripRecyclerView.visibility = View.VISIBLE
        }

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