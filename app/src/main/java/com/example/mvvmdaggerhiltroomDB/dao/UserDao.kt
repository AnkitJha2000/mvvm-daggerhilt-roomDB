package com.example.mvvmdaggerhiltroomDB.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmdaggerhiltroomDB.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    // we have to create DAO i.e. data access object which is an interface
    // we have to declare it with @dao annotation
    // this insert annotation is for insertion in table
    // and this conflict is for if we want to enter the duplicate data it won't be inserted
    // we have declared it suspend cause we have to do this in background without affecting the app performance

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user : User)

    // flow is same as live data
    // we used flow to get the list cause it gives us the live updates in the list
    // we have to write the sql query to get the data from table

    @Query("SELECT * FROM user ORDER BY id ASC")
    fun getUserData() : Flow<List<User>>

}