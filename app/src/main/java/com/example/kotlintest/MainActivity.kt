package com.example.kotlintest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_activity)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.second_activity)
        val nom1 = findViewById<EditText>(R.id.nom)
        val profession1 = findViewById<EditText>(R.id.profession)
        val societe1 = findViewById<EditText>(R.id.societe)

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val nom = nom1.text.toString()
            val profession = profession1.text.toString()
            val societe = societe1.text.toString()
            intent.putExtra("nom", nom)
            intent.putExtra("profession", profession)
            intent.putExtra("societe", societe)
            startActivity(intent)
        }


    }
}