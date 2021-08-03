package com.example.model

data class Post(val title: String,
                val username: String,
                var thumbURL: String,
                var commentCount: String,
                var city: String,
                var date: String,
                var body: String) {
}