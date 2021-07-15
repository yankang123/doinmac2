package com.example.doinmac2.mpdel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(var firstName: String, var lastName: String, var age: Int) {
    @PrimaryKey(autoGenerate = false)
    var id: Long = 0
}
