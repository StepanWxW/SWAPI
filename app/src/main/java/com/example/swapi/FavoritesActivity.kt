package com.example.swapi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritesActivity : AppCompatActivity() {

    val db = DatabaseHelper(this)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        setupUI()
    }

    fun onOnMainButtonClick(view: View) {
        finish()
    }

    fun onClearButtonClick(view: View) {
        db.clearAllTables()
        setupUI()
    }
    // Добавить показ пустого сообщения
    private fun setupUI() {
        val characterList = db.getAllCharacters()
        val recyclerViewCharacter = findViewById<RecyclerView>(R.id.recyclerViewCharacter)
        val characterAdapter = MyAdapter(characterList, this)
        recyclerViewCharacter.adapter = characterAdapter
        recyclerViewCharacter.layoutManager = LinearLayoutManager(this)

        val starshipsList = db.getAllStarships()
        val recyclerViewStarships = findViewById<RecyclerView>(R.id.recyclerViewStarships)
        val starshipsAdapter = MyStarshipAdapter(starshipsList, this)
        recyclerViewStarships.adapter = starshipsAdapter
        recyclerViewStarships.layoutManager = LinearLayoutManager(this)
    }
}