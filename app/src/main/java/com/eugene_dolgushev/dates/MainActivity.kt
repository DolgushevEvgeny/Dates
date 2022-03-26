package com.eugene_dolgushev.dates

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.eugene_dolgushev.dates.eventList.presentation.EventListFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBackStackListener()
        loadFragment(EventListFragment.newInstance(), containerId = R.id.fragment_wrapper)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val fragmentManager = supportFragmentManager
            if (fragmentManager.backStackEntryCount > 0) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                onBackPressed()
            } else {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            }
        }
    }

    private fun initBackStackListener() {
        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            } else {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            }
        }
    }
}