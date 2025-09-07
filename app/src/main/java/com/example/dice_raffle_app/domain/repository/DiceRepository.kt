package com.example.dice_raffle_app.domain.repository

import com.example.dice_raffle_app.domain.model.Dice

interface DiceRepository {
    fun roll(): Dice
}