package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.tanjiro,
                "Tanjiro Kamado",
                "Tanjiro Kamado is the main protagonist of Demon Slayer: Kimetsu No Yaiba. He is a Demon Slayer in " +
                        "the Demon Slayer Corps, who joined to find a remedy to turn his sister, Nezuko Kamado, back into " +
                        "a human and to hunt down and kill demons in order to protect others from suffering the same" +
                        " fate as him."
            ),

            Superhero(
                R.drawable.nezuko,
                "Nezuko Kamado",
                "Nezuko Kamado is the deuteragonist of Demon Slayer: Kimetsu no Yaiba. She is a demon and " +
                        "the younger sister of Tanjiro Kamado and one of the two remaining members of the Kamado family. " +
                        "Formerly a human, she was attacked and turned into a demon by Muzan Kibutsuji."
            ),

            Superhero(
                R.drawable.zenitsu,
                "Zenitsu Agatsuma",
                "Zenitsu Agatsuma is one of the main protagonists of Demon Slayer: Kimetsu no Yaiba and " +
                        "along with Inosuke Hashibira, a travelling companion of Tanjiro Kamado and Nezuko Kamado. " +
                        "He is also a Demon Slayer in the Demon Slayer Corps."
            ),

            Superhero(
                R.drawable.giyu,
                "Giyu Tomioka",
                "Giyu Tomioka is a major supporting character of Demon Slayer: Kimetsu no Yaiba. " +
                        "He is a Demon Slayer of the Demon Slayer Corps and the current Water Hashira"
            ),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this, superheroList){
            val intent = Intent(this, DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}