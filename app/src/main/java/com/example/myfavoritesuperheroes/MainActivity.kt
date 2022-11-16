package com.example.myfavoritesuperheroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var heroesList: ArrayList<Heroes>
    private lateinit var heroesAdapter: HeroesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        heroesList = ArrayList()

        heroesList.add(Heroes(R.drawable.superman, "Superman"))
        heroesList.add(Heroes(R.drawable.batman, "Batman"))
        heroesList.add(Heroes(R.drawable.spider_man, "Spider man"))
        heroesList.add(Heroes(R.drawable.hulk, "Hulk"))
        heroesList.add(Heroes(R.drawable.flash, "Flash"))
        heroesList.add(Heroes(R.drawable.rocker, "Rocket"))
        heroesList.add(Heroes(R.drawable.groot, "Groot"))
        heroesList.add(Heroes(R.drawable.iron_man, "Iron man"))

        heroesAdapter = HeroesAdapter(heroesList)
        recyclerView.adapter = heroesAdapter

        heroesAdapter.onItemClick = {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("heroes", it)
            startActivity(intent)
        }

    }
}