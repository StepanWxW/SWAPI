package com.example.swapi

import StarWarsApiClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var apiClient: StarWarsApiClient

    private lateinit var searchTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchTextView = findViewById(R.id.searchTextView)
        apiClient = StarWarsApiClient()
        // Отслеживайте изменения в тексте элемента ввода и выполняйте поиск при вводе более 2 символов
//        searchTextView.addTextChangedListener { text ->
//            if (text?.length ?: 0 >= 2) {
//                searchCharacters(text.toString())
//            }
//        }
    }

}