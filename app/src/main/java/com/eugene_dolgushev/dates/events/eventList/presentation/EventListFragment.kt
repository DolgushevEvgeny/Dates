package com.eugene_dolgushev.dates.events.eventList.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eugene_dolgushev.dates.BaseFragment
import com.eugene_dolgushev.dates.databinding.FragmentEventListBinding
import com.eugene_dolgushev.dates.setupAsSupportActionbar

class EventListFragment : BaseFragment() {

    private val viewModel: EventListViewModel by lazy {
        viewModel()
    }
    private lateinit var viewBinding: FragmentEventListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentEventListBinding.inflate(inflater, container, false)
        setTitle(TITLE)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAsSupportActionbar(view, TITLE, false)
        with(viewBinding) {
            addEventButton.setOnClickListener {
//                findNavController().navigate()
            }
        }
    }

    companion object {
        private const val TITLE = "Мероприятия"
        fun newInstance() = EventListFragment()
    }
}