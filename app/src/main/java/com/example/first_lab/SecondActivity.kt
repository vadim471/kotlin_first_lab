package com.example.first_lab

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlin.random.Random


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
        setUpBackButtonClickListener()

        val byteBy = intent.getStringExtra("bite_by")
        val variableList = listOf("paper", "scissors", "stone")
        val computerChoice = getComputerChoice(variableList)
        val playerChoice = getPlayerChoice(byteBy)

        val result = getResult(byteBy, computerChoice)

        val computerView : TextView = findViewById(R.id.computerView)
        computerView.text = "Computer Choice: $computerChoice"

        val playerView : TextView = findViewById(R.id.playerView)
        playerView.text = "Player Choice: $playerChoice"

        val resultTextView : TextView = findViewById(R.id.resultTextView)
        resultTextView.text = "Result: $result"

        val layout: LinearLayout = findViewById(R.id.resultView)

        when (result) {
            "You Win!" -> layout.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
            "You Lose(r)!" -> layout.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
        }
    }

    private fun getComputerChoice(list: List<String>): String {
        val randomInt = Random.nextInt(list.size)
        return list[randomInt]
    }

    private fun getResult(myChoice : String?, computerChoice : String) : String {
        return if (myChoice.equals(computerChoice)) {
            "You Lose(r)!" //comp winner
        } else if (
            (myChoice == "paper" && computerChoice == "stone") ||
            (myChoice == "scissors" && computerChoice == "paper") ||
            (myChoice == "stone" && computerChoice == "scissors")
        ) {
            "Draw"
        } else {
            "You Win!"
        }
    }

    private fun getPlayerChoice(biteBy : String?) : String {
        if (biteBy == "paper") {
            return "stone"
        }

        else if (biteBy == "stone") {
            return "scissors"
        }

        else {
            return "paper"
        }
    }

    private fun setUpBackButtonClickListener() {
        findViewById<Button>(R.id.back_button).setOnClickListener {
            this.finish()
        }
    }
}