package com.example.carcards.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class CarData {
    @Entity(tableName = "car_properties_table")
    data class CarData(
        @PrimaryKey(autoGenerate = true)
        var Id: Long = 0L,

        @ColumnInfo(name = "speed")
        val Speed: Int,

        @ColumnInfo(name = "zero_to_hundred")
        val Acceleration: Int,

        @ColumnInfo(name = "weight")
        val Weight: Int
    )
}