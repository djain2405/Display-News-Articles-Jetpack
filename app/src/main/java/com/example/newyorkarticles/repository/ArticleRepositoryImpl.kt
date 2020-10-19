package com.example.newyorkarticles.repository

import androidx.lifecycle.LiveData
import com.example.newyorkarticles.database.ArticleDatabase
import com.example.newyorkarticles.model.Article
import com.example.newyorkarticles.networking.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArticleRepositoryImpl(private val database: ArticleDatabase) : ArticleRepository {

    val articles: LiveData<List<Article>> = database.articleDao.getArticles()

    override suspend fun getArticles(searchTerm: String) {
        withContext(Dispatchers.IO) {
            val articles = Network.getArticles(searchTerm)?.response?.docs
            database.articleDao?.addArticles(articles)
        }
    }
}