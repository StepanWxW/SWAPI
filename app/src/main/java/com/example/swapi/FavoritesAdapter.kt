package com.example.swapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swapi.model.CharacterDB

class FavoritesAdapter(private val characterList: List<CharacterDB>) : RecyclerView.Adapter<FavoritesAdapter.FavoriteViewHolder>() {

    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val genderTextView: TextView = itemView.findViewById(R.id.genderTextView)
        val countStarshipsTextView: TextView = itemView.findViewById(R.id.countStarshipsTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return FavoriteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val currentItem = characterList[position]
        holder.nameTextView.text = currentItem.name
        holder.genderTextView.text = currentItem.gender
        holder.countStarshipsTextView.text = currentItem.countShip.toString()
    }

    override fun getItemCount() = characterList.size
}