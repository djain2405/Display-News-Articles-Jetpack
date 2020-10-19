package com.example.newyorkarticles.networking

import com.example.newyorkarticles.model.Article
import com.example.newyorkarticles.model.ArticleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ArticleSearchService {

    @GET("svc/search/v2/articlesearch.json")
    suspend fun searchArticles(
        @Query("q") searchTerm: String,
        @Query("api-key") apiKey: String = "OKsEwghCzAPR3kRr7Hp51cFn2tMfXWgj"
    ): ArticleResponse
}

object Network {
    private val BASE_URL = "https://api.nytimes.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val articleSearchService = retrofit.create(ArticleSearchService::class.java)

    suspend fun getArticles(searchTerm: String): ArticleResponse {
        return articleSearchService.searchArticles(searchTerm)
    }
}