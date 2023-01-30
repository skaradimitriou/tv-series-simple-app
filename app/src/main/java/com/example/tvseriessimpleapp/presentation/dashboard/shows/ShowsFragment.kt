package com.example.tvseriessimpleapp.presentation.dashboard.shows

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Result
import com.example.tvseriessimpleapp.R
import com.example.tvseriessimpleapp.abstraction.SimplifiedFragment
import com.example.tvseriessimpleapp.databinding.FragmentShowsBinding
import com.example.tvseriessimpleapp.presentation.dashboard.SeriesSharedViewModel
import com.example.tvseriessimpleapp.presentation.dashboard.navigator.Action
import com.example.tvseriessimpleapp.presentation.dashboard.shows.adapter.TvShowsAdapter
import com.example.tvseriessimpleapp.util.setScreenTitle
import com.example.tvseriessimpleapp.util.showSnackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ShowsListFragment : SimplifiedFragment<FragmentShowsBinding>(R.layout.fragment_shows) {

    private val viewModel: ShowsViewModel by viewModels()
    private val sharedViewModel: SeriesSharedViewModel by activityViewModels()

    private val adapter = TvShowsAdapter { selectedTvShow ->
        sharedViewModel.selectedShowId = selectedTvShow.id
        sharedViewModel.navigateToScreen(Action.SHOW_DETAILS)
    }

    override fun init() {
        setScreenTitle(title = getString(R.string.tv_shows_title))
        binding.loading = false

        viewModel.getData()

        binding.tvShowsRecycler.apply {
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
            adapter = this@ShowsListFragment.adapter
        }

        binding.swipeToRefresh.setOnRefreshListener {
            binding.swipeToRefresh.isRefreshing = true
            viewModel.getData()
        }

        viewModel.shows.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> binding.loading = true
                is Result.Success -> {
                    binding.loading = false
                    binding.swipeToRefresh.isRefreshing = false
                    adapter.submitList(result.data)
                }
                is Result.Error -> {
                    binding.loading = false
                    binding.mainConstraint.showSnackbar(result.error.toString())
                }
            }
        }
    }

    override fun startOps() {}

    override fun stopOps() {}
}