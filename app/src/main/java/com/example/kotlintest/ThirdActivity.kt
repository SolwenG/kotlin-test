package com.example.kotlintest

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.third_activity)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.third_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val extras :  Bundle? = intent.extras
        val name = extras?.getString("name")
        val profession =  extras?.getString("profession")
        val society =  extras?.getString("society")

        val form = findViewById<TextView>(R.id.form)
        form.text = "Nom : $name \n \n Profession : $profession \n \n Société : $society"
    }
}