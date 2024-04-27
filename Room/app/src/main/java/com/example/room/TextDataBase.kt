package com.example.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TextEntity::class], version = 1)
abstract class TextDataBase : RoomDatabase(){

    abstract fun textDao() : TextDao

    companion object{

    }
}