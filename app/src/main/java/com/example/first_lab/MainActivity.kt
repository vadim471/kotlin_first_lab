package com.example.first_lab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttons = mapOf("paper" to findViewById<Button>(R.id.stone),
                            "scissors" to findViewById<Button>(R.id.paper),
                            "stone" to findViewById<Button>(R.id.scissors))

        buttons.forEach { (biteBy, button) ->
            button.setOnClickListener {
                openSecondActivity(biteBy)
            }
        }

    }
    private fun openSecondActivity(biteBy : String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("bite_by", biteBy)
        startActivity(intent)
    }
}