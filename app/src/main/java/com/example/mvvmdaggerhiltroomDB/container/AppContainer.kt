package com.example.mvvmdaggerhiltroomDB.container

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// this class will basically store all the dependencies we will use this app
// hilt will take care of it

@HiltAndroidApp
class AppContainer : Application()