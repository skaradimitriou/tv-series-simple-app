package com.example.tvseriessimpleapp.util

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * Helper fun to set screen title.
 */

fun Fragment.setScreenTitle(title: String) {
    requireActivity().title = title
}

fun Context.getActualColor(colorId: Int) = ContextCompat.getColor(this, colorId)