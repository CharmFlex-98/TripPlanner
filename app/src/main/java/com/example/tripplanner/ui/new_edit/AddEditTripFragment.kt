package com.example.tripplanner.ui.new_edit

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.tripplanner.R
import com.example.tripplanner.application.TripApplication
import com.example.tripplanner.databinding.AddEditTripBinding
import com.example.tripplanner.utils.TripViewModelProviderFactory

class AddEditTripFragment : DialogFragment() {
    lateinit var _binding: AddEditTripBinding
    private val _viewModel: NewEditTripViewModel by viewModels {
        TripViewModelProviderFactory {
            NewEditTripViewModel(
                (requireActivity().application as TripApplication).tripRepository
            )
        }
    }

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
            tripName.addTextChangedListener(NewEditTextFieldWatcher { _viewModel.setTripName(it) })
            tripDestination.addTextChangedListener(NewEditTextFieldWatcher {
                _viewModel.setTripDestination(
                    it
                )
            })
            tripDescription.addTextChangedListener(NewEditTextFieldWatcher {
                _viewModel.setTripDescription(
                    it
                )
            })
            tripStartDate.setEndIconOnClickListener {
                println("click")
            }
            createTripButton.setOnClickListener {
                _viewModel.createTrip()
                dismiss()
            }
        }
    }


    /*
    * Text watcher for this page
    * Not sure if this is overkill.
    * Maybe we don't need viewModel for this page?
    */
    private class NewEditTextFieldWatcher(private val _callback: (String) -> Unit) : TextWatcher {
        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
            return
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            return
        }

        override fun afterTextChanged(s: Editable?) {
            _callback(s.toString())
        }

    }
}