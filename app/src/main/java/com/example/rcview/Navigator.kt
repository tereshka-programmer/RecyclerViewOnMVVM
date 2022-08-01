package com.example.rcview

import com.example.rcview.model.User

interface Navigator {

    fun showDetails(user: User)

    fun goBack()

    fun toast(messageRes: Int)

}