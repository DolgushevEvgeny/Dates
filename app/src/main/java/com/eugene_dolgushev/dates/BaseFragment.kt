package com.eugene_dolgushev.dates

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

open class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    protected fun setTitle(title: String) {
        (activity as BaseActivity).supportActionBar?.title = title
    }

    protected fun findNavController() = (activity as MainActivity).navController
}