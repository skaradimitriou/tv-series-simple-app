package com.example.tvseriessimpleapp.presentation.dashboard

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
        navigator = NavigatorImpl(navController)
    }

    override fun startOps() {
        viewModel.navigatorState.observe(this) { action ->
            navigator.navigateTo(action)
        }
    }

    override fun stopOps() {}
}