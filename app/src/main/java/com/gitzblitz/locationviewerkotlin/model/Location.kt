package com.gitzblitz.locationviewerkotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "location")
data class Location(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "location_state")
    var locationState: Boolean? = null,

    @ColumnInfo(name = "location_type_name")
    var locationTypeName: String? = null,

    @ColumnInfo(name = "minor")
    var minor: String? = null,

    @ColumnInfo(name = "major")
    var major: String? = null,

    @ColumnInfo(name = "longitude")
    var longitude: String? = null,

    @ColumnInfo(name = "latitude")
    var latitude: String? = null,

    @ColumnInfo(name = "weather_date")
    var weatherDate: Date? = null,

    @ColumnInfo(name = "temperature")
    var temperature: String? = null

)