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

    class Factory(private val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SearchArticlesViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SearchArticlesViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}