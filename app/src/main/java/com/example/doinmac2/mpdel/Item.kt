package com.example.doinmac2.mpdel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Item")
data class Item(var isChecked :Int,var text :String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}