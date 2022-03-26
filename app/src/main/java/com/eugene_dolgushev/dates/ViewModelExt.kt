package com.eugene_dolgushev.dates

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(): T {
    return ViewModelProvider(this)[T::class.java]
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(crossinline factory: () -> T): T {
    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }

    return ViewModelProvider(this, vmFactory)[T::class.java]
}

inline fun <reified T : ViewModel> Fragment.getViewModel(): T {
    return ViewModelProvider(this)[T::class.java]
}

inline fun <reified T : ViewModel> Fragment.getActivityViewModel(): T? {
    return ViewModelProvider(activity ?: return null)[T::class.java]
}

/**
 * @throws NullPointerException if activity is null
 */
inline fun <reified T : ViewModel> Fragment.getActivityViewModel(crossinline factory: () -> T): T {
    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }

    return ViewModelProvider(activity!!, vmFactory)[T::class.java]
}

inline fun <reified T : ViewModel> Fragment.getActivityViewModelOrNull(crossinline factory: () -> T): T? {
    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }

    return ViewModelProvider(activity ?: return null, vmFactory)[T::class.java]
}

inline fun <reified T : ViewModel> Fragment.getViewModel(crossinline factory: () -> T): T {
    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }

    return ViewModelProvider(this, vmFactory)[T::class.java]
}

inline fun <reified T : ViewModel> Fragment.getSavedStateViewModel(crossinline factory: (SavedStateHandle) -> T): T {
    val vmFactory = object : AbstractSavedStateViewModelFactory(this, null) {
        override fun <U : ViewModel> create(
            key: String,
            modelClass: Class<U>,
            handle: SavedStateHandle
        ): U = factory(handle) as U
    }

    return ViewModelProvider(this, vmFactory)[T::class.java]
}
