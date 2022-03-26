package com.eugene_dolgushev.dates

import android.os.Bundle
import android.text.TextUtils
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

open class BaseActivity : AppCompatActivity() {

    private lateinit var titleView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        titleView = TextView(this)
        titleView.ellipsize = TextUtils.TruncateAt.END
        titleView.maxLines = 1
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        titleView.setTextColor(ContextCompat.getColor(this, android.R.color.white))
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }
}