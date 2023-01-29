package com.example.domain.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.domain.models.TvShow
import kotlinx.coroutines.flow.Flow

@Dao
interface TvShowsDao {

    @Query("SELECT * FROM shows ORDER BY title ASC")
    fun getAllCountries(): Flow<List<TvShow>>

    @Insert
    suspend fun insertAll(list: List<TvShow>)

    @Update
    suspend fun updateAll(list: List<TvShow>)

    @Query("DELETE FROM shows")
    suspend fun deleteAll()
}