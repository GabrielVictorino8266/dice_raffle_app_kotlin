package com.example.dice_raffle_app.data.repository

import com.example.dice_raffle_app.UtilDice
import com.example.dice_raffle_app.domain.model.Dice
import com.example.dice_raffle_app.domain.repository.DiceRepository
import kotlin.random.Random

class DiceRepositoryImpl : DiceRepository {
    override fun roll(): Dice {
        val number = Random.nextInt(UtilDice.DICE_FROM_VALUE, UtilDice.DICE_TO_VALUE)
        return Dice(number)
    }
}