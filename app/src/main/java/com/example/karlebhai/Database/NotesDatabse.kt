package com.example.karlebhai.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.karlebhai.Dao.NotesDao
import com.example.karlebhai.Models.Notes

@Database(entities = [Notes::class],version = 1)
abstract class NotesDatabse:RoomDatabase() {
    abstract fun myNotesDatabse(): NotesDao


    companion object {
        /*A companion object is an object that's declared in the same file as a class , and has the same name as the class.
        A companion object and its class can access each other's private members. A companion object's apply method lets
        you create new instances of a class without using the new keyword.*/
        @Volatile
        private var INSTANCE:NotesDatabse? = null

        fun getDatabaseInstance(context:Context):NotesDatabse{
            val tempInstance = INSTANCE
          if(tempInstance!=null){
            return tempInstance
          }
            synchronized(this)
            {
               INSTANCE = Room.databaseBuilder(context.applicationContext,NotesDatabse::class.java,"Notes").build()
                return INSTANCE!!
            }
        }


    }
}