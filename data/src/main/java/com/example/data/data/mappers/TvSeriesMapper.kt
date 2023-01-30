package com.example.data.data.mappers

import com.example.data.models.TvShowDto
import com.example.domain.models.TvShow

object TvSeriesMapper : Mapper<List<TvShowDto?>, List<TvShow>> {

    override fun toDomainModel(dto: List<TvShowDto?>): List<TvShow> = dto.map {
        TvShow(
            title = it?.name.toNotNull(),
            description = it?.summary.toNotNull(),
            mainGenre = it?.genres?.firstOrNull().toNotNull(),
            imageUrl = it?.image?.original.toNotNull(),
            rating = it?.rating?.average.toNotNull()
        )
    } ?: listOf()

    private fun String?.toNotNull(): String = this ?: ""

    private fun Double?.toNotNull(): Double = this ?: 0.0
}