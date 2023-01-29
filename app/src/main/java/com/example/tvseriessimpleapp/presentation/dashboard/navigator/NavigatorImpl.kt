package com.example.tvseriessimpleapp.presentation.dashboard.navigator

import androidx.navigation.NavController
import com.example.tvseriessimpleapp.R
import javax.inject.Inject

class NavigatorImpl @Inject constructor(
    private val navController: NavController
) : Navigator {

    override fun navigateTo(screenKey: Action) = when (screenKey) {
        Action.TV_SHOWS -> navController.navigate(R.id.showsListFragment)
        Action.SHOW_DETAILS -> navController.navigate(R.id.showDetailsScreen)
        else -> Unit
    }
}