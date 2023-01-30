package com.example.tvseriessimpleapp.util

import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

/**
 * Helper fun to set screen title.
 */

fun Fragment.setScreenTitle(title: String) {
    requireActivity().title = title
}

fun View.showSnackbar(msg: String) {
    Snackbar.make(this, msg, Snackbar.LENGTH_LONG).show()
}