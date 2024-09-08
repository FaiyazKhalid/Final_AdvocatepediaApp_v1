package com.advocatepedia.lite.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

const val DayImageTableName = "day_image"

private const val ThumbnailIdColumnName = "thumbnail_id"
private const val ImageIdColumnName = "full_size_image_id"
private const val DescriptionColumnName = "description_id"

@Entity(
    tableName = DayImageTableName,
    foreignKeys = [
        ForeignKey(
            entity = DatabaseImage::class,
            parentColumns = ["id"],
            childColumns = [ThumbnailIdColumnName]
        ),
        ForeignKey(
            entity = DatabaseImage::class,
            parentColumns = ["id"],
            childColumns = [ImageIdColumnName]
        ),
    ],
    indices = [
        Index(ThumbnailIdColumnName),
        Index(ImageIdColumnName),
    ],
)
data class DatabaseDayImage(
    @PrimaryKey
    val titleAndId: String,
    // Foreign keys
    @ColumnInfo(name = ThumbnailIdColumnName)
    val thumbnailId: String,

    @ColumnInfo(name = ImageIdColumnName)
    val imageId: String,
    // /Foreign keys

    val description: String,
)