package com.example.newyorkarticles.model

data class ArticleResponse(val response: ArticleDocs)
data class ArticleDocs(val docs: List<Article>)
data class Article(
    val _id: String,
    val uri: String,
    val web_url: String
)