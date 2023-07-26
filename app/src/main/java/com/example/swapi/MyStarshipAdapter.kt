package com.example.swapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.swapi.model.Starship

class MyStarshipAdapter(private val starshipsList: List<Starship>, private val context: Context) : RecyclerView.Adapter<MyStarshipAdapter.MyStarshipViewHolder>() {

    private val db = DatabaseHelper(context)

    class MyStarshipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val modelTextView: TextView = itemView.findViewById(R.id.modelTextView)
        val manufacturerTextView: TextView = itemView.findViewById(R.id.manufacturerTextView)
        val passengersTextView: TextView = itemView.findViewById(R.id.passengersTextView)
        val addToFavoritesButtonSH: Button = itemView.findViewById(R.id.addToFavoritesButtonSH)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyStarshipViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.starships_item, parent, false)
        return MyStarshipViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyStarshipViewHolder, position: Int) {
        val currentItem = starshipsList[position]
        holder.nameTextView.text = currentItem.name
        holder.modelTextView.text = currentItem.model
        holder.manufacturerTextView.text = currentItem.manufacturer
        holder.passengersTextView.text = currentItem.passengers
        if (currentItem.url != null) {
            holder.addToFavoritesButtonSH.setOnClickListener {
                val starship = Starship(currentItem.name, currentItem.model, currentItem.manufacturer, currentItem.passengers)
                db.insertStarship(starship)
                Toast.makeText(context, "Добавили в избранное", Toast.LENGTH_LONG).show()
            }
        } else {
            holder.addToFavoritesButtonSH.visibility = View.GONE
        }
    }

    override fun getItemCount() = starshipsList.size
}