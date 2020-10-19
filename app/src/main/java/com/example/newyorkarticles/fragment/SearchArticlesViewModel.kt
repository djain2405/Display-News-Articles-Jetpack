package com.example.newyorkarticles.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newyorkarticles.model.Article
import com.example.newyorkarticles.networking.Network
import kotlinx.coroutines.*

class SearchArticlesViewModel : ViewModel() {
    private val _articles = MutableLiveData<List<Article>>()

    val articles: LiveData<List<Article>>
        get() = _articles


    fun fetchArticles(searchTerm: String) {
        viewModelScope.launch() {
            withContext(Dispatchers.IO) {
                val articles = Network.getArticles(searchTerm)?.response?.docs
                withContext(Dispatchers.Main) {
                    _articles.value = articles
                }
            }
        }
    }
}