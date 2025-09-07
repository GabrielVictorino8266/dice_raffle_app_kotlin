package com.example.dice_raffle_app

import com.example.dice_raffle_app.data.repository.DiceRepositoryImpl
import com.example.dice_raffle_app.domain.usecase.RollDiceUseCase
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DiceUnitTest {
    private val useCase = RollDiceUseCase(DiceRepositoryImpl())


    @Test
    fun testeRandomDice() {
        repeat(100) {
            val resultado = useCase.execute()
            assertTrue(resultado.numero in 1..6)
        }
    }
}