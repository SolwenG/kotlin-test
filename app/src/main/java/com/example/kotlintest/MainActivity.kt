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
        val getName = findViewById<EditText>(R.id.name)
        val getProfession = findViewById<EditText>(R.id.profession)
        val getSociety = findViewById<EditText>(R.id.society)

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val name = getName.text.toString()
            val profession = getProfession.text.toString()
            val society = getSociety.text.toString()

            intent.putExtra("name", name)
            intent.putExtra("profession", profession)
            intent.putExtra("society", society)
            startActivity(intent)
        }
    }
}