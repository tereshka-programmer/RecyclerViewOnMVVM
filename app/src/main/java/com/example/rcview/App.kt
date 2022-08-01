package com.example.rcview

import android.app.Application
import com.example.rcview.model.UsersService

class App : Application() {

    val usersService = UsersService()
}