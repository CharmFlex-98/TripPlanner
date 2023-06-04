package com.example.tripplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.tripplanner.databinding.AddEditTripBinding

class AddEditTripFragment: DialogFragment() {
    lateinit var _binding: AddEditTripBinding

    companion object {
        const val fragmentName = "add_edit_trip_fragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AddEditTripBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.apply {
            tripStartDate.setOnClickListener(null)
            createTripButton.setOnClickListener {
                dismiss()
            }
        }
    }
}