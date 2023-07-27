package com.example.swapi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swapi.adapter.CharacterAdapter
import com.example.swapi.adapter.StarshipAdapter
import com.example.swapi.db.DatabaseHelper

class FavoritesActivity : AppCompatActivity() {

    val db = DatabaseHelper(this)
    private lateinit var recyclerViewCharacter: RecyclerView;
    private lateinit var recyclerViewStarships: RecyclerView;
    private lateinit var textViewCharacter: TextView
    private lateinit var textViewStarship: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        recyclerViewCharacter = findViewById(R.id.recyclerViewCharacter)
        recyclerViewStarships = findViewById(R.id.recyclerViewStarships)
        textViewCharacter = findViewById(R.id.textViewCharacter)
        textViewStarship = findViewById(R.id.textViewStarship)
        setupUI()
    }

    fun onOnMainButtonClick(view: View) {
        finish()
    }

    fun onClearButtonClick(view: View) {
        db.clearAllTables()
        setupUI()
    }
    private fun setupUI() {
        setupUICharacter()
        setupUIStarship()
    }

    private fun setupUICharacter() {
        val characterList = db.getAllCharacters()
        if (characterList.isEmpty()) {
            showMessage("У вас нет сохраненных персонажей", textViewCharacter, recyclerViewCharacter)
            return
        }
        val characterAdapter = CharacterAdapter(characterList, this)
        recyclerViewCharacter.adapter = characterAdapter
        recyclerViewCharacter.layoutManager = LinearLayoutManager(this)
    }
    private fun setupUIStarship() {
        val starshipsList = db.getAllStarships()
        if (starshipsList.isEmpty()) {
            showMessage("У вас нет сохраненных здездолетов", textViewStarship, recyclerViewStarships)
            return
        }
        val starshipsAdapter = StarshipAdapter(starshipsList, this)
        recyclerViewStarships.adapter = starshipsAdapter
        recyclerViewStarships.layoutManager = LinearLayoutManager(this)
    }

    private fun showMessage(message: String, textView: TextView, recyclerView: RecyclerView) {
        textView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        textView.text = message
    }
}