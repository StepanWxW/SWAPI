package com.example.swapi

import com.example.swapi.network.StarWarsApiClient
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swapi.adapter.CharacterAdapter
import com.example.swapi.adapter.StarshipAdapter
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var apiClient: StarWarsApiClient

    private lateinit var enterNameTextView: EditText
    private lateinit var startSearchButton: Button
    private lateinit var spinner: Spinner
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CharacterAdapter
    private lateinit var messageTextView: TextView

    private val context = this
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterNameTextView = findViewById(R.id.enterNameTextView)
        startSearchButton = findViewById(R.id.startSearchButton)
        spinner = findViewById(R.id.spinner)
        messageTextView = findViewById(R.id.textViewMessage)
        recyclerView = findViewById(R.id.recyclerView)
        apiClient = StarWarsApiClient()

        startSearchButton.setOnClickListener {
            val selectedOption = spinner.selectedItem as String
            val searchString = enterNameTextView.text.toString()
            if (searchString.length < 2) {
                showMessage("Введите больше 2 символов")
            } else {
                if (selectedOption == "персонажу") {
                    lifecycleScope.launch {
                        try {
                            val characterResponse = apiClient.searchCharacters(searchString)
                            if (characterResponse.results.isNotEmpty()) {
                                showRecyclerView()
                                adapter = CharacterAdapter(characterResponse.results, context)
                                recyclerView.adapter = adapter
                                recyclerView.layoutManager = LinearLayoutManager(context)
                            } else{
                                showMessage("Нет таких персонажей")
                            }
                        } catch (e: Exception) {
                            showMessage(e)
                        }
                    }
                }
                if (selectedOption == "звездолету") {
                    lifecycleScope.launch {
                        try {
                            val starshipResponse = apiClient.searchStarships(searchString)
                            if (starshipResponse.results.isNotEmpty()) {
                                showRecyclerView()
                                val adapter = StarshipAdapter(starshipResponse.results, context)
                                recyclerView.adapter = adapter
                                recyclerView.layoutManager = LinearLayoutManager(context)
                            } else{
                                showMessage("Нет таких звезлотелов")
                            }
                        } catch (e: Exception) {
                            showMessage(e)
                        }
                    }
                }
            }
        }
    }

    private fun showMessage(e: Exception) {
        showMessage("Проверьте соединение с интернетом")
        println("ошибка +$e")
    }

    private fun showMessage(message: String) {
        messageTextView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        messageTextView.text = message
    }

    private fun showRecyclerView() {
        messageTextView.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    fun onFavoritesButtonClick(view: View) {
        val intent = Intent(this, FavoritesActivity::class.java)
        startActivity(intent)
    }
}