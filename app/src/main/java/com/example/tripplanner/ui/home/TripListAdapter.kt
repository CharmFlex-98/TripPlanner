package com.example.tripplanner.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tripplanner.databinding.TripListItemBinding
import com.example.tripplanner.model.Trip
import java.util.zip.Inflater

class TripListAdapter: ListAdapter<Trip, TripListAdapter.TripViewHolder>(diffUtils) {

    companion object {
        val diffUtils = object: DiffUtil.ItemCallback<Trip>() {
            override fun areItemsTheSame(oldItem: Trip, newItem: Trip): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Trip, newItem: Trip): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }

    class TripViewHolder(private val _binding: TripListItemBinding): ViewHolder(_binding.root) {

        fun bind(trip: Trip) {
            _binding.tripDestination.text = trip.destination
            _binding.tripDescription.text = trip.description
        }
    }

    // Implementation starts here

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
        val binding = TripListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TripViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
        return holder.bind(currentList[position])
    }
}