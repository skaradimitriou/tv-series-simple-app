package com.example.tvseriessimpleapp.presentation.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tvseriessimpleapp.presentation.dashboard.navigator.Action

class SeriesSharedViewModel : ViewModel() {

    val navigatorState: LiveData<Action>
        get() = _navigatorState

    private val _navigatorState = MutableLiveData<Action>()

    var selectedShowId: Int? = null

    fun navigateToScreen(action: Action) {
        _navigatorState.postValue(action)
    }
}