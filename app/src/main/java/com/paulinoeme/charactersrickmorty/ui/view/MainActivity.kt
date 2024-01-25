package com.paulinoeme.charactersrickmorty.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.paulinoeme.charactersrickmorty.R
import com.paulinoeme.charactersrickmorty.data.network.CharactersApiClient
import com.paulinoeme.charactersrickmorty.databinding.ActivityMainBinding
import com.paulinoeme.charactersrickmorty.ui.recyclerview.RecyclerViewAdapter
import com.paulinoeme.charactersrickmorty.viewmodel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: RecyclerViewAdapter
    private val characterViewModel: CharactersViewModel by viewModels()

    private var page: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        characterViewModel.onCreate()

        characterViewModel.characterModel.observe(this, Observer {
            adapter = RecyclerViewAdapter(it)
            binding.rvCharacters.layoutManager = LinearLayoutManager(this)
            binding.rvCharacters.adapter = adapter
            binding.tvPage.text = "Page $page"
        })

        binding.btnleft.setOnClickListener {
            if(page <= 1)
                page = 42
            else
                page--

            characterViewModel.getCharactersPage("character/?page=${page}")
        }

        binding.btnRight.setOnClickListener {
            if(page >= 42)
                page = 1
            else
                page++

            characterViewModel.getCharactersPage("character/?page=${page}")
        }
    }
}