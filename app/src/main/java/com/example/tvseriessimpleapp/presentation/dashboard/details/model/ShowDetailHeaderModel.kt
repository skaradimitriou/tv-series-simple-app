package com.example.tvseriessimpleapp.presentation.dashboard.details.model

import com.example.domain.models.UiModel

data class ShowDetailHeaderModel(
    val imageUrl: String,
    val title: String,
    val rating: Double
) : UiModel {
    override fun equalsContent(model: UiModel): Boolean = when (model) {
        is ShowDetailHeaderModel -> title == model.title
        else -> false
    }
}
