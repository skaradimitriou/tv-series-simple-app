package com.example.tvseriessimpleapp.presentation.dashboard

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.models.TvShow
import com.example.tvseriessimpleapp.abstraction.SimplifiedViewModel
import com.example.tvseriessimpleapp.presentation.dashboard.navigator.Action
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SeriesSharedViewModel @Inject constructor(
    app: Application
) : SimplifiedViewModel(app) {

    val navigatorState: LiveData<Action>
        get() = _navigatorState

    private val _navigatorState = MutableLiveData<Action>()

    var selectedShow: TvShow? = null

    fun navigateToScreen(action: Action) {
        _navigatorState.postValue(action)
    }
}