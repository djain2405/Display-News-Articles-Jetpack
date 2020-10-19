package com.example.newyorkarticles.fragment

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.newyorkarticles.database.ArticleDatabase
import com.example.newyorkarticles.model.Article
import com.example.newyorkarticles.networking.Network
import com.example.newyorkarticles.repository.ArticleRepositoryImpl
import kotlinx.coroutines.*

class SearchArticlesViewModel(application: Application) : AndroidViewModel(application) {
    private val database by lazy {
        ArticleDatabase.getInstance(application)
    }
    private val repository by lazy {
        ArticleRepositoryImpl(database)
    }

    val articles: LiveData<List<Article>>
        get() = repository.articles

    fun fetchArticles(searchTerm: String) {
        viewModelScope.launch() {
            repository.getArticles(searchTerm)
        }
    }
}