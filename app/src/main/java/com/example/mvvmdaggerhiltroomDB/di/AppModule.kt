package com.example.mvvmdaggerhiltroomDB.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmdaggerhiltroomDB.dao.UserDao
import com.example.mvvmdaggerhiltroomDB.database.UserDatabase
import com.example.mvvmdaggerhiltroomDB.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context : Context) : UserDatabase =
        Room.databaseBuilder(context , UserDatabase::class.java ,"user").build()

    @Provides
    fun providesUserDao(userDatabase: UserDatabase) : UserDao =
        userDatabase.userDao()

    @Provides
    fun providesUserRepository(userDao : UserDao) : UserRepository =
        UserRepository(userDao)


}