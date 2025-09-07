package com.example.dice_raffle_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dice_raffle_app.domain.model.Dice
import com.example.dice_raffle_app.domain.usecase.RollDiceUseCase

class DiceViewModel(private val rollDiceUseCase: RollDiceUseCase) : ViewModel() {
    private val _dice = MutableLiveData<Dice>()
    val dice: LiveData<Dice> = _dice

    fun rollDice(){
        _dice.value = rollDiceUseCase.execute()
    }
}