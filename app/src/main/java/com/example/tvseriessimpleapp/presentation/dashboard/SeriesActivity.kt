package com.example.tvseriessimpleapp.presentation.dashboard

import androidx.activity.viewModels
import com.example.tvseriessimpleapp.R
import com.example.tvseriessimpleapp.abstraction.SimplifiedActivity
import com.example.tvseriessimpleapp.databinding.ActivitySeriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesActivity : SimplifiedActivity<ActivitySeriesBinding>(R.layout.activity_series) {

    private val viewModel: SeriesSharedViewModel by viewModels()

    override fun init() {

    }

    override fun startOps() {
        viewModel.getData()

        viewModel.shows.observe(this) { list ->
            if (list.isNotEmpty()) {
                binding.txtView.text = "${list.size} fetched from remote"
            }
        }
    }

    override fun stopOps() {}
}