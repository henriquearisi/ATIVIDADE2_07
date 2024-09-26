package com.example.a07

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var targetNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa o número aleatório
        targetNumber = Random.nextInt(1, 101)

        // Referências para os elementos da interface
        val guessInput = findViewById<EditText>(R.id.guessInput)
        val checkButton = findViewById<Button>(R.id.checkButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        checkButton.setOnClickListener {
            // Obter valor inserido pelo usuário
            val guessText = guessInput.text.toString()

            if (guessText.isNotEmpty()) {
                val guess = guessText.toIntOrNull()

                if (guess != null) {
                    // Verificar o palpite
                    resultText.text = when {
                        guess < targetNumber -> "Seu palpite é muito baixo."
                        guess > targetNumber -> "Seu palpite é muito alto."
                        else -> "Parabéns! Você acertou."
                    }
                } else {
                    resultText.text = "Por favor, insira um número válido."
                }
            } else {
                resultText.text = "Por favor, insira um palpite."
            }
        }
    }
}
