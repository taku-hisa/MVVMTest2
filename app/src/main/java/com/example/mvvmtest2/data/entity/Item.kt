package com.example.mvvmtest2.data.entity

data class Item(
    val body: String,
    val editing: Boolean,
    val comments_count: Int,
    val created_at: String,
    val group: Group,
    val id: String,
    val likes_count: Int,
    val page_views_count: Int,
    val `private`: Boolean,
    val reactions_count: Int,
    val rendered_body: String,
    val tags: List<Tag>,
    val title: String,
    val updated_at: String,
    val url: String,
    val user: User
)