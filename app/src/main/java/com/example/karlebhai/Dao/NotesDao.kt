package com.example.karlebhai.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.karlebhai.Models.Notes

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTitle(notes: Notes)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubTitle(notes: Notes)

    @Insert(onConflict = OnConflictStrategy.REPLACE) //if we get the same query then the onflict method will replace it
    suspend fun insertNotes(notes: Notes)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDate(notes: Notes)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPriority(notes: Notes)


    @Query("SELECT * FROM Notes")
    fun getNotes():LiveData<List<Notes>>

    @Query("SELECT * FROM Notes WHERE priority=3")
    fun getHighPriority():LiveData<List<Notes>>

    @Query("SELECT * FROM Notes WHERE priority=2")
    fun getMediumPriority():LiveData<List<Notes>>

    @Query("SELECT * FROM Notes WHERE priority=1")
    fun getLowPriority():LiveData<List<Notes>>



    @Query("DELETE FROM Notes Where id=:id")
    suspend fun deleteNotes(id:Int)

    @Update
    suspend fun updateNotes(notes: Notes)
}