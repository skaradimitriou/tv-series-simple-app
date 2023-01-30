package com.example.tvseriessimpleapp.util

import androidx.fragment.app.Fragment

/**
 * Helper fun to set screen title.
 */

fun Fragment.setScreenTitle(title: String) {
    requireActivity().title = title
}