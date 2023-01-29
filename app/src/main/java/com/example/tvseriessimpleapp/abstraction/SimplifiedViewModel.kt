package com.example.tvseriessimpleapp.abstraction

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class SimplifiedViewModel(app: Application) : AndroidViewModel(app) {

    fun getString(resourceId: Int) = getApplication<Application>().getString(resourceId)
}