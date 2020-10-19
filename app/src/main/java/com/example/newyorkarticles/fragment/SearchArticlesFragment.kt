package com.example.newyorkarticles.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        search_button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.articleDetailFragment)
        }
    }
}