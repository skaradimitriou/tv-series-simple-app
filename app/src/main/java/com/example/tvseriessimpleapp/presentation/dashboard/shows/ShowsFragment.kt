package com.example.tvseriessimpleapp.presentation.dashboard.shows

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.tvseriessimpleapp.R
import com.example.tvseriessimpleapp.abstraction.SimplifiedFragment
import com.example.tvseriessimpleapp.databinding.FragmentShowsBinding
import com.example.tvseriessimpleapp.presentation.dashboard.SeriesSharedViewModel
import com.example.tvseriessimpleapp.presentation.dashboard.navigator.Action
import com.example.tvseriessimpleapp.presentation.dashboard.shows.adapter.TvShowsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ShowsListFragment : SimplifiedFragment<FragmentShowsBinding>(R.layout.fragment_shows) {

    private val viewModel: ShowsViewModel by viewModels()
    private val sharedViewModel: SeriesSharedViewModel by activityViewModels()

    private val adapter = TvShowsAdapter { selectedTvShow ->
        sharedViewModel.selectedShow = selectedTvShow
        sharedViewModel.navigateToScreen(Action.SHOW_DETAILS)
    }

    override fun init() {
        binding.tvShowsRecycler.apply {
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
            adapter = this@ShowsListFragment.adapter
        }
    }

    override fun startOps() {
        viewModel.getData()

        viewModel.shows.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }

    override fun stopOps() {}
}