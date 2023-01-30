package com.example.tvseriessimpleapp.presentation.dashboard.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.UiModel
import com.example.tvseriessimpleapp.R
import com.example.tvseriessimpleapp.abstraction.SimpleDiffUtil
import com.example.tvseriessimpleapp.databinding.HolderEmptyItemBinding
import com.example.tvseriessimpleapp.databinding.HolderTvShowDetailDescriptionItemBinding
import com.example.tvseriessimpleapp.databinding.HolderTvShowDetailHeaderItemBinding
import com.example.tvseriessimpleapp.presentation.dashboard.details.model.ShowDescriptionModel
import com.example.tvseriessimpleapp.presentation.dashboard.details.model.ShowDetailHeaderModel

class ShowDetailsAdapter() : ListAdapter<UiModel, RecyclerView.ViewHolder>(SimpleDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.holder_tv_show_detail_header_item -> {
                val view = HolderTvShowDetailHeaderItemBinding.inflate(inflater, parent, false)
                ShowDetailsViewHolder(view)
            }
            R.layout.holder_tv_show_detail_description_item -> {
                val view = HolderTvShowDetailDescriptionItemBinding.inflate(inflater, parent, false)
                ShowDescriptionViewHolder(view)
            }
            else -> {
                val view = HolderEmptyItemBinding.inflate(inflater, parent, false)
                EmptyViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when (holder) {
        is ShowDetailsViewHolder -> holder.bind(getItem(position))
        is ShowDescriptionViewHolder -> holder.bind(getItem(position))
        else -> Unit
    }

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is ShowDetailHeaderModel -> R.layout.holder_tv_show_detail_header_item
        is ShowDescriptionModel -> R.layout.holder_tv_show_detail_description_item
        else -> R.layout.holder_empty_item
    }
}