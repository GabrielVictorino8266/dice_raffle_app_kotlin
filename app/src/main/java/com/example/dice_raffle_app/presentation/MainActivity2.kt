package com.example.dice_raffle_app.presentation

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dice_raffle_app.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val diceImageView =  findViewById<ImageView>(R.id.imagemResultado)
        val botaoVoltar = findViewById<ImageButton>(R.id.botaoVoltar)

        val diceResult : Bundle? = intent.extras
        val numero = diceResult?.getInt("dice_resultado", 6)

        val ImageResultado = when(numero){
            1 -> R.drawable.dado_lado_um
            2 -> R.drawable.dado_lado_dois
            3 -> R.drawable.dado_lado_tres
            4 -> R.drawable.dado_lado_quatro
            5 -> R.drawable.dado_lado_cinco
            6 -> R.drawable.dado_lado_seis
            else -> R.drawable.dado_lado_seis
        }

        diceImageView.setImageResource(ImageResultado)

        botaoVoltar.setOnClickListener{
            finish()
        }
    }
}