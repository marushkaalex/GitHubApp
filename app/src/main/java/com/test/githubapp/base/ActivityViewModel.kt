package com.test.githubapp.base

import android.content.Intent
import android.content.res.Configuration
import android.databinding.BaseObservable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

abstract class ActivityViewModel : BaseObservable() {

    fun onBackKeyPress(): Boolean {
        return false
    }

    fun onStart() {

    }

    fun onStop() {

    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    fun onDestroy() {

    }

    fun onPause() {

    }

    fun onResume() {

    }

    fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray) {

    }

    fun onPostCreate(savedInstanceState: Bundle?) {

    }

    fun onOptionsItemSelected(item: MenuItem) {

    }

    fun onConfigurationChanged(newConfig: Configuration) {

    }

    fun onRestoreInstanceState(savedInstanceState: Bundle) {

    }

    fun onSaveInstanceState(outState: Bundle) {

    }

    fun onCreateOptionsMenu(menu: Menu) {

    }

    fun onPrepareOptionsMenu(menu: Menu) {

    }

    fun onWindowFocusChanged(hasFocus: Boolean) {

    }
}