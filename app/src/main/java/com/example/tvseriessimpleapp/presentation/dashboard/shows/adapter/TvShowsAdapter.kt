package com.example.tvseriessimpleapp.presentation.dashboard.shows.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.models.UiModel
import com.example.tvseriessimpleapp.abstraction.SimpleDiffUtil
import com.example.tvseriessimpleapp.databinding.HolderTvShowItemBinding

class TvShowsAdapter(
    private val callback: TvShowCallback
) : ListAdapter<UiModel, TvShowsViewHolder>(SimpleDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val view = HolderTvShowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}