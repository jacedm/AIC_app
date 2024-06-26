package com.example.aic_app.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aic_app.data.api.models.Artwork
import com.example.aic_app.ui.model.Art

@Entity(tableName = "favorites")
data class FavoritesEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val title: String,
    val date: String,
    val artist: String,
    val imageId: String,
    val isFavorite: Boolean
) {
    fun toArt(): Art {
        return Art(
            id = id,
            title = title,
            date = date,
            artist = artist,
            imageId = imageId,
            isFavorite = isFavorite
        )
    }

    companion object {

        fun toFavoriteEntity(art: Art): FavoritesEntity {

            val title = art.title
            val date = art.date
            val artist = art.artist

            return FavoritesEntity(
                id = art.id,
                title = title,
                date = date,
                artist = artist,
                imageId = art.imageId,
                isFavorite = true
            )
        }
    }
}
