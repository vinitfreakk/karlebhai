package com.example.karlebhai.Models
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var subTitile: String,
    var notes: String,
    var date: String,
    var priority: String
)
