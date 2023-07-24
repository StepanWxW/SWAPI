package com.example.swapi

import StarWarsApiClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var apiClient: StarWarsApiClient

    private lateinit var searchTextView: TextView
    private lateinit var startSearchButton: Button
    private lateinit var spinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchTextView = findViewById(R.id.searchTextView)
        startSearchButton = findViewById(R.id.startSearchButton)
        spinner = findViewById(R.id.spinner)
        apiClient = StarWarsApiClient()

        startSearchButton.setOnClickListener {
            val selectedOption = spinner.selectedItem as String
            val searchString = searchTextView.text.toString()
            if(selectedOption == "персонажу"){
                lifecycleScope.launch {
                    val characterResponse = apiClient.searchCharacters(searchString)
                    val character = characterResponse.results[0]

                }
            }
            if(selectedOption == "звездолету"){

            }
        }
    }
}