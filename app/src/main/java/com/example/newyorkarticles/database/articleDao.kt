package com.example.newyorkarticles.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newyorkarticles.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addArticles(articles: List<Article>)

    @Query("SELECT * from articles")
    fun getArticles(): List<Article>

    @Query("SELECT * from articles WHERE _id=:articleId")
    fun getArticleById(articleId: String): Article
}