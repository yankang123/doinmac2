package com.example.doinmac2.mpdel

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemDao {
    @Insert
    fun insertItem(item: Item): Long
    @Update
    fun updateItem(item: Item)
    @Query("SELECT * FROM Item")
    fun loadAllItems(): List<Item>
//    @Query("select * from Item where isChecked==:isChecked")
//    fun loadCheckedItems(isChecked:Int):List<Item>
    @Delete
    fun deleteItem(item: Item)
}