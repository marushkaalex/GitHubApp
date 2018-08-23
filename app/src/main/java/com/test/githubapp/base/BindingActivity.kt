package com.test.githubapp.base

import android.content.Intent
import android.content.res.Configuration
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import javax.inject.Inject
import javax.inject.Singleton


abstract class BindingActivity<B : ViewDataBinding, VM : ActivityViewModel>
    : AppCompatActivity() {

    lateinit var binding: B
        private set

    @Inject
    @Singleton
    protected lateinit var viewModel: VM

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDependencies()
        viewModel.onCreate()
        bind()
    }

    abstract fun initDependencies()

    fun bind() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
//        this.viewModel = if (!::viewModel.isInitialized) onCreate() else viewModel
        binding.setVariable(getVariable(), viewModel)
        binding.executePendingBindings()
    }

//    fun resetViewModel() {
//        viewModel = onCreate()
//        binding.setVariable(getVariable(), viewModel)
//    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

    override fun onStop() {
        viewModel.onStop()
        super.onStop()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.onActivityResult(requestCode, resultCode, data)
    }

    override fun onPause() {
        viewModel.onPause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onBackPressed() {
        if (!viewModel.onBackKeyPress()) {
            super.onBackPressed()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    public override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        viewModel.onPostCreate(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.onOptionsItemSelected(item)
        return super.onOptionsItemSelected(item)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        viewModel.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        viewModel.onConfigurationChanged(newConfig)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        viewModel.onCreateOptionsMenu(menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        viewModel.onPrepareOptionsMenu(menu)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        viewModel.onWindowFocusChanged(hasFocus)
    }

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    @IdRes
    abstract fun getVariable(): Int

    /**
     * Override for set layout resource
     *
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int
}