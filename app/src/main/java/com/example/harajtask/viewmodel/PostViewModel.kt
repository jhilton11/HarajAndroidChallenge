package com.example.harajtask.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.harajtask.repository.PostRepository
import com.example.model.Post
import com.google.gson.Gson

class PostViewModel(application: Application) : AndroidViewModel(application) {
    val postLiveData: MutableLiveData<List<Post>> = MutableLiveData()

    fun getPosts() {
        postLiveData.value = PostRepository(getApplication()).posts
    }
}