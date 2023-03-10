package com.example.tvseriessimpleapp.presentation.dashboard

import android.view.MenuItem
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.tvseriessimpleapp.R
import com.example.tvseriessimpleapp.abstraction.SimplifiedActivity
import com.example.tvseriessimpleapp.databinding.ActivitySeriesBinding
import com.example.tvseriessimpleapp.presentation.dashboard.navigator.NavigatorImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesActivity : SimplifiedActivity<ActivitySeriesBinding>(R.layout.activity_series) {

    private val viewModel: SeriesSharedViewModel by viewModels()

    private lateinit var navController: NavController
    private lateinit var navigator: NavigatorImpl

    override fun init() {
        navController = findNavController(R.id.nav_host_fragment)
        navigator = NavigatorImpl(this, navController)
    }

    override fun startOps() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val isAtDetailsScreen = destination.id == R.id.showDetailsScreen
            supportActionBar?.setDisplayHomeAsUpEnabled(isAtDetailsScreen)
        }

        viewModel.navigatorState.observe(this) { action ->
            action?.let { navigator.navigateTo(it) }
        }
    }

    override fun stopOps() {}

    override fun onBackPressed() {
        navigator.goBack()
        viewModel.resetNavigation()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            navigator.goBack()
            viewModel.resetNavigation()
            true
        }
        else -> false
    }
}