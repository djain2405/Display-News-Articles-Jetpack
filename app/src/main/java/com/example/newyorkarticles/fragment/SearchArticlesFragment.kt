package com.example.newyorkarticles.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.newyorkarticles.R
import kotlinx.android.synthetic.main.fragment_main.*

class SearchArticlesFragment : Fragment() {

    private lateinit var searchArticlesViewModel: SearchArticlesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        searchArticlesViewModel =
            ViewModelProvider(this).get(SearchArticlesViewModel::class.java)
        searchArticlesViewModel.articles.observe(viewLifecycleOwner, Observer {
            Log.d("SearchArticlesFragment", "Live Data of Articles: ${it?.get(0)?.web_url}")
        })


        search_button.setOnClickListener {

            if (search_articles_bar.text?.isEmpty()!!) {
                Toast.makeText(
                    activity?.applicationContext,
                    "Please enter a valid search Term",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                search_articles_bar?.text?.toString()
                    ?.let { it1 -> searchArticlesViewModel.fetchArticles(searchTerm = it1) }
            }

        }
    }
}