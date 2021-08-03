package com.example.harajtask.repository

import android.app.Application
import com.example.model.Post
import com.google.gson.Gson

class PostRepository(private val application: Application) {

    val jsonString: String by lazy {
        application.applicationContext.assets.open("data.json").bufferedReader().use{
            it.readText()
        }
    }

    val posts: List<Post> by lazy {
        Gson().fromJson(jsonString, Array<Post>::class.java).toList()
    }

}