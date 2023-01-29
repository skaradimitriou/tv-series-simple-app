package com.example.tvseriessimpleapp.presentation.dashboard.shows.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.TvShow
import com.example.domain.models.UiModel
import com.example.tvseriessimpleapp.databinding.HolderTvShowItemBinding

class TvShowsViewHolder(
    private val binding: HolderTvShowItemBinding,
    private val callback: TvShowCallback
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(uiModel: UiModel) = when (uiModel) {
        is TvShow -> {
            binding.model = uiModel
            binding.callback = callback
        }
        else -> Unit
    }
}