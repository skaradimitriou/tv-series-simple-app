package com.example.data.mappers

import com.example.data.models.TvShowDto
import com.example.domain.models.TvShow

object TvSeriesMapper : Mapper<TvShowDto?, TvShow> {

    override fun toDomainModel(dto: TvShowDto?): TvShow = TvShow(
        title = dto?.name.toNotNull(),
        description = dto?.summary.toNotNull(),
        imageUrl = dto?.image?.original.toNotNull(),
        rating = dto?.rating?.average.toNotNull()
    )

    private fun String?.toNotNull(): String = this ?: ""

    private fun Double?.toNotNull(): Double = this ?: 0.0
}