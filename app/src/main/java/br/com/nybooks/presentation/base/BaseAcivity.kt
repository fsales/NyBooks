package br.com.nybooks.presentation.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open abstract class BaseAcivity : AppCompatActivity() {

    protected fun setupToolbar(toolbar: Toolbar, titleIdRes: Int, showBackButton:Boolean = false) {
        toolbar.title = getString(titleIdRes)
        setSupportActionBar(toolbar)
        if(showBackButton) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}