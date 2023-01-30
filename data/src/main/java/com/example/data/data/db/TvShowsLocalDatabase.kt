package com.example.data.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.domain.models.TvShow

@Database(
    entities = arrayOf(TvShow::class),
    version = 5,
    exportSchema = false
)
abstract class TvShowsLocalDatabase : RoomDatabase() {

    abstract fun showsDao(): TvShowsDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: TvShowsLocalDatabase? = null

        fun getDatabase(context: Context): TvShowsLocalDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TvShowsLocalDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private const val DB_NAME = "tv_shows_db"
    }
}