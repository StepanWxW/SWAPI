package com.example.swapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.swapi.model.Character
import com.example.swapi.model.CharacterDB

class MyAdapter(private val charactersList: List<Character>, private val context: Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val db = CharacterDatabaseHelper(context)

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val genderTextView: TextView = itemView.findViewById(R.id.genderTextView)
        val countStarshipsTextView: TextView = itemView.findViewById(R.id.countStarshipsTextView)
        val addToFavoritesButton: Button = itemView.findViewById(R.id.addToFavoritesButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = charactersList[position]
        holder.nameTextView.text = currentItem.name
        holder.genderTextView.text = currentItem.gender
        holder.countStarshipsTextView.text = currentItem.starships.size.toString()

        holder.addToFavoritesButton.setOnClickListener {
            val characterDB = CharacterDB(currentItem.name, "male", currentItem.starships.size)
            db.insertCharacter(characterDB)
            Toast.makeText(context, "Добавили в избранное", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount() = charactersList.size
}