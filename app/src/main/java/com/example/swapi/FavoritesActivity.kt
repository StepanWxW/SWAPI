package com.example.swapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val db = CharacterDatabaseHelper(this)
        val characterList = db.getAllCharacters() // Получите список CharacterDB из базы данных
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewFavorites)
        val adapter = FavoritesAdapter(characterList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun onOnMainButtonClick(view: View) {
        finish()
    }
}