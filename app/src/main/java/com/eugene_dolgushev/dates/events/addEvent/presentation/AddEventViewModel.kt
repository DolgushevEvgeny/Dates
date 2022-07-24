package com.eugene_dolgushev.dates.events.addEvent.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class AddEventViewModel() : ViewModel() {

    private val titleLiveData = MutableLiveData<String>()
    private val descriptionLiveData = MutableLiveData<String>()

    private fun observeTitle(
        lifecycleOwner: LifecycleOwner,
        observer: Observer<String>
    ) = titleLiveData.observe(lifecycleOwner, observer)

    private fun observeDescription(
        lifecycleOwner: LifecycleOwner,
        observer: Observer<String>
    ) = descriptionLiveData.observe(lifecycleOwner, observer)

    fun saveEvent() {

    }
}