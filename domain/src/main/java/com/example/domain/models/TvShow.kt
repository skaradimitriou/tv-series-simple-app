package com.example.domain.models

data class TvShow(
    val title: String,
    val imageUrl: String,
    val description: String,
    val rating: Double
) : UiModel {
    override fun equalsContent(model: UiModel): Boolean = when (model) {
        is TvShow -> title == model.title && imageUrl == model.imageUrl && description == model.description && model.rating == model.rating
        else -> false
    }
}
