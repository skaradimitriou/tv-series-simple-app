package com.example.tvseriessimpleapp.presentation.dashboard.details

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.tvseriessimpleapp.R
import com.example.tvseriessimpleapp.abstraction.SimplifiedFragment
import com.example.tvseriessimpleapp.databinding.FragmentShowDetailsBinding
import com.example.tvseriessimpleapp.presentation.dashboard.SeriesSharedViewModel

class ShowDetailsScreen : SimplifiedFragment<FragmentShowDetailsBinding>(R.layout.fragment_show_details) {

    private val viewModel: ShowDetailsViewModel by viewModels()
    private val sharedViewModel: SeriesSharedViewModel by activityViewModels()

    override fun init() {
        sharedViewModel.selectedShow?.let {
            binding.model = it
        }
    }

    override fun startOps() {}

    override fun stopOps() {}
}