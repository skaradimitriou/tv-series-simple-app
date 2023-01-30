package com.example.tvseriessimpleapp.presentation.dashboard.details.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.UiModel
import com.example.tvseriessimpleapp.databinding.HolderEmptyItemBinding
import com.example.tvseriessimpleapp.databinding.HolderTvShowDetailDescriptionItemBinding
import com.example.tvseriessimpleapp.databinding.HolderTvShowDetailHeaderItemBinding
import com.example.tvseriessimpleapp.presentation.dashboard.details.model.ShowDescriptionModel
import com.example.tvseriessimpleapp.presentation.dashboard.details.model.ShowDetailHeaderModel

class ShowDetailsViewHolder(
    private val binding: HolderTvShowDetailHeaderItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(uiModel: UiModel) = when (uiModel) {
        is ShowDetailHeaderModel -> binding.model = uiModel
        else -> Unit
    }
}

class ShowDescriptionViewHolder(
    private val binding: HolderTvShowDetailDescriptionItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(uiModel: UiModel) = when (uiModel) {
        is ShowDescriptionModel -> binding.model = uiModel
        else -> Unit
    }
}

class EmptyViewHolder(
    binding: HolderEmptyItemBinding
) : RecyclerView.ViewHolder(binding.root) {
}