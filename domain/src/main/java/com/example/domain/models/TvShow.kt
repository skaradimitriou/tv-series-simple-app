package com.example.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shows")
data class TvShow(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "imageUrl")
    val imageUrl: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "rating")
    val rating: Double
) : UiModel {
    override fun equalsContent(model: UiModel): Boolean = when (model) {
        is TvShow -> title == model.title && imageUrl == model.imageUrl && description == model.description && model.rating == model.rating
        else -> false
    }
}
