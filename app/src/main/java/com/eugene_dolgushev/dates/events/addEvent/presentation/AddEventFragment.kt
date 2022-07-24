package com.eugene_dolgushev.dates.events.addEvent.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.widget.doAfterTextChanged
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eugene_dolgushev.dates.BaseFragment
import com.eugene_dolgushev.dates.R
import com.eugene_dolgushev.dates.databinding.FragmentAddEventBinding
import com.eugene_dolgushev.dates.utils.extensions.getViewModel
import com.google.android.material.textfield.TextInputEditText

class AddEventFragment : BaseFragment(R.layout.fragment_add_event) {

    private val viewBinding by viewBinding(FragmentAddEventBinding::bind)
    private val viewModel by lazy {
        getViewModel {
            AddEventViewModel()
        }
    }
    private lateinit var editTextTitle: TextInputEditText
    private lateinit var editTextDescription: TextInputEditText
    private lateinit var buttonAdd: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextTitle = viewBinding.editTextTitle
        editTextDescription = viewBinding.editTextDescription
        buttonAdd = viewBinding.buttonAdd

        editTextTitle.doAfterTextChanged {

        }

        buttonAdd.setOnClickListener {
            viewModel.saveEvent()
        }
    }
}