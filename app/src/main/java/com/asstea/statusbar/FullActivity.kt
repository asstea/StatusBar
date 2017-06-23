package com.asstea.statusbar

import android.os.Bundle

class FullActivity(override val layoutResID: Int = R.layout.activity_full) : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun statusBarColor(): Int {
        return android.R.color.transparent
    }

    override fun isFitsSystemWindows(): Boolean {
        return false
    }
}
