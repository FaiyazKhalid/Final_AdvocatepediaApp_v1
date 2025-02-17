package com.advocatepedia.lite.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val OnThisDayTableName = "on_this_day"

@Entity(tableName = OnThisDayTableName)
data class DatabaseOnThisDay(
    val text: String,
    val year: Int,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var onThisDayId: Long = 0
}