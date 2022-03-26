package com.eugene_dolgushev.dates.eventList.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eugene_dolgushev.dates.BaseFragment
import com.eugene_dolgushev.dates.R
import com.eugene_dolgushev.dates.databinding.EventListFragmentBinding
import com.eugene_dolgushev.dates.loadFragment

class EventListFragment : BaseFragment() {

    private val viewModel: EventListViewModel by lazy {
        viewModel()
    }
    private lateinit var viewBinding: EventListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = EventListFragmentBinding.inflate(inflater, container, false)
        setTitle(TITLE)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            addEventButton.setOnClickListener {
                loadFragment(
                    newInstance(),
                    containerId = R.id.fragment_wrapper,
                    true
                )
            }
        }
    }

    companion object {
        private const val TITLE = "Мероприятия"
        fun newInstance() = EventListFragment()
    }
}