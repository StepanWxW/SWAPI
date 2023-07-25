package com.example.swapi

import StarWarsApiClient
import android.content.Context
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
import com.example.swapi.model.Character
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var apiClient: StarWarsApiClient

    private lateinit var enterNameTextView: EditText
    private lateinit var startSearchButton: Button
    private lateinit var spinner: Spinner
    private val context = this
//    private val itemList = mutableListOf<Item>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    private lateinit var character: Character

//    private lateinit var characterLayout: LinearLayout
//    private lateinit var characterNameTextView: TextView
//    private lateinit var genderTextView: TextView
//    private lateinit var countStarshipsTextView: TextView
//
//    private lateinit var starshipLayout: LinearLayout
//    private lateinit var starshipNameTextView: TextView
//    private lateinit var modelTextView: TextView
//    private lateinit var manufacturerTextView: TextView
//    private lateinit var passengersTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterNameTextView = findViewById(R.id.enterNameTextView)
        startSearchButton = findViewById(R.id.startSearchButton)
//        starshipLayout = findViewById(R.id.starshipLayout)
//        characterLayout = findViewById(R.id.characterLayout)
        spinner = findViewById(R.id.spinner)

        recyclerView = findViewById(R.id.recyclerView)


//        val nameTextView = characterLayout.findViewById<TextView>(R.id.nameTextView)
//        val genderTextView = characterLayout.findViewById<TextView>(R.id.genderTextView)
//        val countStarshipsTextView = characterLayout.findViewById<TextView>(R.id.countStarshipsTextView)

        apiClient = StarWarsApiClient()

        startSearchButton.setOnClickListener {
            val selectedOption = spinner.selectedItem as String
            val searchString = enterNameTextView.text.toString()
            if(selectedOption == "персонажу"){
                lifecycleScope.launch {
                    val characterResponse = apiClient.searchCharacters(searchString)
                    if(characterResponse.results.isNotEmpty()){
                        adapter = MyAdapter(characterResponse.results)
                        recyclerView.adapter = adapter

                        recyclerView.layoutManager = LinearLayoutManager(context)
                    }

//                    if(characterResponse.results.isNotEmpty()) {
//                        character = characterResponse.results[0]
//                        starshipLayout.visibility = View.GONE
//                        characterLayout.visibility = View.VISIBLE
//                        nameTextView.text = character.name
//                        genderTextView.text = character.gender
//                        countStarshipsTextView.text = character.starships.size.toString()
//                    }
                }
            }
            if(selectedOption == "звездолету"){

            }
        }
    }
}