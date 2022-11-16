package com.example.myfavoritesuperheroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class HeroesAdapter(private val heroList:ArrayList<Heroes>): RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>(){

    var onItemClick : ((Heroes) -> Unit)? = null

    class HeroesViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val textView : TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return HeroesViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        val heroes = heroList[position]
        holder.imageView.setImageResource(heroes.image)
        holder.textView.text = heroes.name

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(heroes)
        }
    }

    override fun getItemCount(): Int {
        return heroList.size
    }


}