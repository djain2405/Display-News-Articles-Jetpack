package com.example.newyorkarticles.fragment

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.newyorkarticles.model.Article
import com.example.newyorkarticles.model.ArticleResponse
import com.example.newyorkarticles.networking.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchArticlesViewModel : ViewModel() {
    var articles: List<Article>? = listOf()
    private val callback = object : Callback<ArticleResponse> {
        override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {
            Log.d(
                "SearchArticlesViewModel",
                "articles are in count: ${response?.body()?.response?.docs?.size}"
            )
        }

        override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
            Log.d(
                "SearchArticlesViewModel",
                "articles are errored out: ${t?.message}"
            )
        }
    }


    init {
        Network.getArticles(callback)
    }
}