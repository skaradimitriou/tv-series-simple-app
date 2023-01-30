package com.example.tvseriessimpleapp.presentation.dashboard.details.model

import com.example.domain.models.UiModel

data class ShowDescriptionModel(
    val description: String
) : UiModel {
    override fun equalsContent(model: UiModel): Boolean = when (model) {
        is ShowDescriptionModel -> description == model.description
        else -> false
    }
}
