package com.eugene_dolgushev.dates.events.eventList.presentation

import com.eugene_dolgushev.dates.utils.extensions.getViewModel

fun EventListFragment.viewModel(
): EventListViewModel {
    return getViewModel(
    )
}