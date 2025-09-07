package com.example.dice_raffle_app.domain.usecase

import com.example.dice_raffle_app.domain.model.Dice
import com.example.dice_raffle_app.domain.repository.DiceRepository

class RollDiceUseCase (private val repository: DiceRepository) {
    fun execute(): Dice = repository.roll()
}