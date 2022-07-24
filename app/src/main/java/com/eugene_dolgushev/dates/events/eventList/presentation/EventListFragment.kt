package com.eugene_dolgushev.dates.events.eventList.presentation

import android.os.Bundle
import android.text.Layout
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eugene_dolgushev.dates.BaseFragment
import com.eugene_dolgushev.dates.R
import com.eugene_dolgushev.dates.databinding.FragmentEventListBinding
import com.eugene_dolgushev.dates.setupAsSupportActionbar

class EventListFragment : BaseFragment(R.layout.fragment_event_list) {

    private val viewBinding by viewBinding(FragmentEventListBinding::bind)
    private val viewModel: EventListViewModel by lazy {
        viewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAsSupportActionbar(view, TITLE, false)
        with(viewBinding) {
            addEventButton.setOnClickListener {
                findNavController().navigate(EventListFragmentDirections.actionToAddEventFragment())
            }
        }
    }

    companion object {
        private const val TITLE = "Мероприятия"
    }
}