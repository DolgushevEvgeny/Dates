package com.eugene_dolgushev.dates.events.addEvent.presentation

import SingleLiveEvent
import androidx.lifecycle.*
import com.eugene_dolgushev.dates.Result
import com.eugene_dolgushev.dates.events.addEvent.domain.CreateEventUseCase
import com.eugene_dolgushev.dates.utils.extensions.getViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun AddEventFragment.viewModelFactory(
    createEventUseCase: CreateEventUseCase
) = getViewModel {
        AddEventViewModel(createEventUseCase = createEventUseCase)
    }

class AddEventViewModel(private val createEventUseCase: CreateEventUseCase) : ViewModel() {

    private val titleLiveData = MutableLiveData("")
    private val descriptionLiveData = MutableLiveData("")

    private val successEvent = SingleLiveEvent<Unit>()
    private val errorEvent = SingleLiveEvent<String>()

    fun observeTitle(
        lifecycleOwner: LifecycleOwner,
        observer: Observer<String>
    ) = titleLiveData.observe(lifecycleOwner, observer)

    fun observeDescription(
        lifecycleOwner: LifecycleOwner,
        observer: Observer<String>
    ) = descriptionLiveData.observe(lifecycleOwner, observer)

    fun observeErrorEvent(
        lifecycleOwner: LifecycleOwner,
        observer: Observer<String>
    ) = errorEvent.observe(lifecycleOwner, observer)

    fun observeSuccessEvent(
        lifecycleOwner: LifecycleOwner,
        observer: Observer<Unit>
    ) = successEvent.observe(lifecycleOwner, observer)

    fun updateTitle(newTitle: String) {
        titleLiveData.value = newTitle
    }

    fun updateDescription(newDescription: String) {
        descriptionLiveData.value = newDescription
    }

    fun saveEvent() {
        val title = titleLiveData.value ?: ""
        val description = descriptionLiveData.value ?: ""
        viewModelScope.launch(Dispatchers.Default) {
            when (val result = createEventUseCase.execute(title, description)) {
                is Result.Error -> errorEvent.postValue(result.error)
                Result.Success -> successEvent.postCall()
            }
        }
    }
}