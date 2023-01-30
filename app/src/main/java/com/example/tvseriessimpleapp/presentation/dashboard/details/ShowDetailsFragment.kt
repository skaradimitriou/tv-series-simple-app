package com.example.tvseriessimpleapp.presentation.dashboard.details

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.tvseriessimpleapp.R
import com.example.tvseriessimpleapp.abstraction.SimplifiedFragment
import com.example.tvseriessimpleapp.databinding.FragmentShowDetailsBinding
import com.example.tvseriessimpleapp.presentation.dashboard.SeriesSharedViewModel
import com.example.tvseriessimpleapp.presentation.dashboard.details.adapter.ShowDetailsAdapter
import com.example.tvseriessimpleapp.util.setScreenTitle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowDetailsScreen :
    SimplifiedFragment<FragmentShowDetailsBinding>(R.layout.fragment_show_details) {

    private val viewModel: ShowDetailsViewModel by viewModels()
    private val sharedViewModel: SeriesSharedViewModel by activityViewModels()

    private val adapter = ShowDetailsAdapter()

    override fun init() {
        binding.showDetailsRecycler.adapter = adapter

        sharedViewModel.selectedShowId?.let {
            viewModel.getShowInfo(it)
        }
    }

    override fun startOps() {
        viewModel.screenTitle.observe(viewLifecycleOwner) { title ->
            setScreenTitle(title)
        }

        viewModel.showDetails.observe(viewLifecycleOwner) { showDetails ->
            adapter.submitList(showDetails)
        }
    }

    override fun stopOps() {}
}