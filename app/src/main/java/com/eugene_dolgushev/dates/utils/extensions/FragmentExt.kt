package com.eugene_dolgushev.dates

import androidx.fragment.app.Fragment

fun Fragment.loadFragment(
    fragment: Fragment,
    containerId: Int,
    addToBackStack: Boolean = false
) {
    val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(containerId, fragment)
    if (addToBackStack) {
        fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
    }
    fragmentTransaction.commit()
}

