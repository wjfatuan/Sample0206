package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var numberLeft = 0
    var numberRight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /**
         * 1. dos variables con los numeros
         * 2. al dar clic validar con un condicional si es el numero grande
         *   2.1 si si, mostrar "ganaste"
         *   2.2. si no, mostrar "perdiste"
         */

        initNumbers()

        val buttonLeft = findViewById<Button>(R.id.buttonLeft)
        buttonLeft.setOnClickListener {
            checkWinner(numberLeft, numberRight)
        }
        val buttonRight = findViewById<Button>(R.id.buttonRight)
        buttonRight.setOnClickListener {
            checkWinner(numberRight, numberLeft)
        }


    }

    fun initNumbers() {
        numberLeft = (0..100).random()
        numberRight = (0..100).random()
    }

    fun checkWinner(big: Int, small: Int ) {
        if (small < big) {
            Toast.makeText(this, "Ganaste", Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this, "Perdiste", Toast.LENGTH_LONG).show()
        }
        initNumbers()
    }
}