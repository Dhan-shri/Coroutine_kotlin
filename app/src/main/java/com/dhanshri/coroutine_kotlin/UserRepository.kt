package com.dhanshri.coroutine_kotlin

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User>{
        delay(8000)
        val users : List<User> = listOf(
            User(1,"Dhanshri"),
            User(2,"Dhanshri"),
            User(3,"Dhanshri"),
            User(4,"Dhanshri"),

        )
        return users
    }
}