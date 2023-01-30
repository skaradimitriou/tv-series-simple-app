package com.example.tvseriessimpleapp.presentation.dashboard.navigator

import android.app.Activity
import androidx.navigation.NavController
import com.example.tvseriessimpleapp.R
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class NavigatorImpl @Inject constructor(
    private val activity: Activity?,
    private val navController: NavController
) : Navigator {

    override fun navigateTo(screenKey: Action) = when (screenKey) {
        Action.TV_SHOWS -> navController.navigate(R.id.showsListFragment)
        Action.SHOW_DETAILS -> navController.navigate(R.id.showDetailsScreen)
    }

    override fun goBack() {
        if (navController.graph.startDestinationId == navController.currentDestination?.id) {
            activity?.finish()
        } else {
            navController.popBackStack(R.id.showsListFragment, false)
        }
    }
}