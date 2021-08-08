package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // znalezienie przycisku w layoucie
        val rollButton: Button = findViewById(R.id.button)

        // co sie dzieje jeśli wciśniemy przycisk (rzucamy kostką)
        rollButton.setOnClickListener {
            rollDice()
        }
        // rzucenie kostka kiedy włączamy aplikacje
        rollDice()
    }

    private fun rollDice() {
        // stworzenie obiektu dice z 6 stronami
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

// creating dice class
class Dice(private val sides: Int) {

    fun roll(): Int {
        return (1..sides).random()
    }
}