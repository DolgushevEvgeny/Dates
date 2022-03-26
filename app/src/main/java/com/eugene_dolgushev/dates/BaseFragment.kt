package com.eugene_dolgushev.dates

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    protected fun setTitle(title: String) {
        (activity as MainActivity).supportActionBar?.title = title
    }
}