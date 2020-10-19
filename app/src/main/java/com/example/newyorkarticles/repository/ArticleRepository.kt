package com.example.newyorkarticles.repository

interface ArticleRepository {

    suspend fun getArticles(searchTerm: String)
}