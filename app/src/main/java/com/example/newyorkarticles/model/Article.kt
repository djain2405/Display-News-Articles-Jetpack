package com.example.newyorkarticles.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ArticleResponse(val response: ArticleDocs)
data class ArticleDocs(val docs: List<Article>)

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey
    val _id: String,
    val uri: String,
    val web_url: String
//    val headline: Headline
)

data class Headline(
    val name: String,
    val main: String,
    val sub: String

)