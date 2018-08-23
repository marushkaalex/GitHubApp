package com.test.githubapp.base

import android.content.Intent
import android.content.res.Configuration
import android.databinding.BaseObservable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

abstract class ActivityViewModel : BaseObservable() {

    open fun onBackKeyPress(): Boolean {
        return false
    }

    open fun onCreate() {

    }

    open fun onStart() {

    }

    open fun onStop() {

    }

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    open fun onDestroy() {

    }

    open fun onPause() {

    }

    open fun onResume() {

    }

    open fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray) {

    }

    open fun onPostCreate(savedInstanceState: Bundle?) {

    }

    open fun onOptionsItemSelected(item: MenuItem) {

    }

    open fun onConfigurationChanged(newConfig: Configuration) {

    }

    open fun onRestoreInstanceState(savedInstanceState: Bundle) {

    }

    open fun onSaveInstanceState(outState: Bundle) {

    }

    open fun onCreateOptionsMenu(menu: Menu) {

    }

    open fun onPrepareOptionsMenu(menu: Menu) {

    }

    open fun onWindowFocusChanged(hasFocus: Boolean) {

    }
}