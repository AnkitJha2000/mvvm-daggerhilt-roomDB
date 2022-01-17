package com.example.mvvmdaggerhiltroomDB.model

import androidx.room.PrimaryKey
import org.w3c.dom.Entity

@androidx.room.Entity(tableName = "user")
data class User(val name : String , val age : Int) {

    @PrimaryKey(autoGenerate = true)
    var id : Int? = null

}