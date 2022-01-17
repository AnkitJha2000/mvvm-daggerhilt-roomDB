package com.example.mvvmdaggerhiltroomDB.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmdaggerhiltroomDB.dao.UserDao
import com.example.mvvmdaggerhiltroomDB.model.User

@Database(entities = [User::class] , version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

}