package com.example.swapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swapi.model.Character

class MyAdapter(private val charactersList: List<Character>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

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
            // Здесь можно выполнить действие при добавлении в избранное
            // Например, вы можете использовать currentItem для получения информации об элементе
        }
    }

    override fun getItemCount() = charactersList.size
}