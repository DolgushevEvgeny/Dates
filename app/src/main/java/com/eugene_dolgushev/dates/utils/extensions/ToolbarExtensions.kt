package com.eugene_dolgushev.dates

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment

fun Fragment.setupAsSupportActionbar(
    toolbarParent: View,
    titleRes: Int = -1,
    showAsUp: Boolean = true
) {
    val toolbar: Toolbar = toolbarParent.findViewById(R.id.toolbar)
    val titleString = if (titleRes != -1) {
        getString(titleRes)
    } else {
        null
    }
    setupAsSupportActionbar(toolbar, titleString, showAsUp)
}

fun Fragment.setupAsSupportActionbar(
    toolbarParent: View,
    title: String?,
    showAsUp: Boolean = true
) {
    val toolbar: Toolbar = toolbarParent.findViewById(R.id.toolbar)
    setupAsSupportActionbar(toolbar, title, showAsUp)
}

fun Fragment.setupSupportActionBarTitle(title: String?) {
    (activity as AppCompatActivity).apply {
        supportActionBar?.title = title
    }
}

fun Fragment.setupAsSupportActionbar(toolbar: Toolbar, title: String?, showAsUp: Boolean = true) {
    (activity as AppCompatActivity).apply {
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(ResourcesCompat.getColor(toolbar.resources, R.color.black, null))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(showAsUp)
            this.title = title
        }
    }
}