package com.example.kotlintest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.second_activity)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val extras :  Bundle? = intent.extras
        val nom = extras?.getString("nom")
        val profession =  extras?.getString("profession")
        val societe =  extras?.getString("societe")

        val form = findViewById<TextView>(R.id.form)
        form.text = "Nom : $nom \n Profession : $profession \n Société : $societe"

        val button = findViewById<Button>(R.id.third_activity)
        button.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("nom", nom)
            intent.putExtra("profession", profession)
            intent.putExtra("societe", societe)
            startActivity(intent)
        }
    }
}