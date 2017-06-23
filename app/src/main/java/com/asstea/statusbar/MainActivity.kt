package com.asstea.statusbar

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity(override val layoutResID: Int = R.layout.activity_main) : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        holo_blue_bright.setOnClickListener {
            showStatusBarColor(android.R.color.holo_blue_bright)
        }
        holo_green_dark.setOnClickListener {
            showStatusBarColor(android.R.color.holo_green_dark)
        }
        holo_red_dark.setOnClickListener {
            showStatusBarColor(android.R.color.holo_red_dark)
        }
        full_activity.setOnClickListener {
            startActivity(Intent(this@MainActivity, FullActivity::class.java))
        }

    }

    override fun statusBarColor(): Int {
        return R.color.colorAccent
    }


}
