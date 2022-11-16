package com.example.myfavoritesuperheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val heroes = intent.getParcelableExtra<Heroes>("heroes")
        if (heroes != null){
            val textView : TextView = findViewById(R.id.detailedActivityTv)
            val imageView : ImageView = findViewById(R.id.detailedActivityIv)
            val description : TextView = findViewById(R.id.description)

            textView.text = heroes.name
            imageView.setImageResource(heroes.image)

            val name = heroes.name

            val result = when (name){
                "Superman" -> getString(R.string.superman)
                "Batman" -> getString(R.string.batman)
                "Spider man" -> getString(R.string.spiderman)
                "Hulk" -> getString(R.string.hulk)
                "Flash" -> getString(R.string.flash)
                "Rocket" -> getString(R.string.rocket)
                "Groot" -> getString(R.string.groot)
                "Iron man" -> getString(R.string.ironman)
                else -> "Invalid"
            }
            description.text = result
        }

    }
}