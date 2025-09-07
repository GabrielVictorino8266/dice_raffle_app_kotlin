package com.example.dice_raffle_app.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import com.example.dice_raffle_app.R
import com.example.dice_raffle_app.data.repository.DiceRepositoryImpl
import com.example.dice_raffle_app.domain.usecase.RollDiceUseCase

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: DiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = DiceViewModel(RollDiceUseCase(DiceRepositoryImpl()))

        viewModel.dice.observe(this){ dice ->
            val numero: Int = dice.numero
            val intent = Intent(applicationContext, MainActivity2::class.java)
            intent.putExtra("dice_resultado", numero)
            startActivity(intent)
        }

        val botaoJogar = findViewById<ImageButton>(R.id.botaoJogar)

        botaoJogar.setOnClickListener{
            viewModel.rollDice()


        }
    }
}