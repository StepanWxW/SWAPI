package com.example.swapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.swapi.R
import com.example.swapi.db.DatabaseHelper
import com.example.swapi.model.Character

class CharacterAdapter(private val charactersList: List<Character>, private val context: Context) : RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    private val db = DatabaseHelper(context)

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val genderTextView: TextView = itemView.findViewById(R.id.genderTextView)
        val countStarshipsTextView: TextView = itemView.findViewById(R.id.countStarshipsTextView)
        val addToFavoritesButton: Button = itemView.findViewById(R.id.addToFavoritesButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.character_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = charactersList[position]
        holder.nameTextView.text = currentItem.name
        holder.genderTextView.text = currentItem.gender
        holder.countStarshipsTextView.text = currentItem.starships.size.toString()
        if(currentItem.url !=  null){
            holder.addToFavoritesButton.setOnClickListener {
                val character = Character(currentItem.name, "male", currentItem.starships.size)
                db.insertCharacter(character)
                Toast.makeText(context, "Добавили в избранное", Toast.LENGTH_LONG).show()
            }
        } else {
            holder.addToFavoritesButton.visibility = View.GONE
        }
    }

    override fun getItemCount() = charactersList.size
}