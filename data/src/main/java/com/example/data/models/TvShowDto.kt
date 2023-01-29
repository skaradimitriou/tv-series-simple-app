package com.example.data.models

data class TvShowDto(
    val id: Int? = null,
    val url: String? = null,
    val name: String? = null,
    val type: String? = null,
    val language: String? = null,
    val image: ImageDto? = null,
    val summary: String? = null,
    val rating: RatingDto? = null
)
