package com.asstea.statusbar

import android.os.Build
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import com.readystatesoftware.systembartint.SystemBarTintManager


/**
 * author : asstea
 * time   : 2017/06/23
 * desc   :
 */
abstract class AppBaseActivity : AppCompatActivity() {

    abstract val layoutResID: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResID)
        setStatusBar()
    }

    private fun setStatusBar() {
        if (systemBarTint()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = resources.getColor(statusBarColor())
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                val tintManager = SystemBarTintManager(this)
                tintManager.isStatusBarTintEnabled = true
                tintManager.setTintResource(statusBarColor())
            }
            val mContentView = findViewById(Window.ID_ANDROID_CONTENT) as ViewGroup
            val mChildView = mContentView.getChildAt(0)
            mChildView?.let {
                ViewCompat.setFitsSystemWindows(mChildView, isFitsSystemWindows())
            }
        }
    }

    fun showStatusBarColor(@ColorRes color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = resources.getColor(color)
            } else {
                val tintManager = SystemBarTintManager(this)
                tintManager.isStatusBarTintEnabled = true
                tintManager.setTintResource(color)
            }
        }
    }

    open protected fun isFitsSystemWindows(): Boolean {
        return true
    }

    open protected fun statusBarColor(): Int {
        return R.color.colorPrimary
    }

    open protected fun systemBarTint(): Boolean {
        return true
    }
}