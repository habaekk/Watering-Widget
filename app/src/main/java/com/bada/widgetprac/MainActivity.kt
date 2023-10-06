package com.bada.widgetprac

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val counterNum = findViewById<TextView>(R.id.numCups)

        val cup1 = findViewById<ImageView>(R.id.cup1)
        val cup2 = findViewById<ImageView>(R.id.cup2)
        val cup3 = findViewById<ImageView>(R.id.cup3)
        val cup4 = findViewById<ImageView>(R.id.cup4)
        val cup5 = findViewById<ImageView>(R.id.cup5)
        val cup6 = findViewById<ImageView>(R.id.cup6)
        val cup7 = findViewById<ImageView>(R.id.cup7)
        val cup8 = findViewById<ImageView>(R.id.cup8)
        val cup9 = findViewById<ImageView>(R.id.cup9)
        val cup10 = findViewById<ImageView>(R.id.cup10)


        var counter = 0

        val cups = arrayOf(cup1, cup2, cup3, cup4, cup5, cup6, cup7, cup8, cup9, cup10)
        /*

        val plusButton = findViewById<ImageButton>(R.id.plusButton)
        val minusButton = findViewById<ImageButton>(R.id.minusButton)


        plusButton.setOnClickListener {
            println("plus")
            counter++
            if (counter > 10) counter = 10

            MyApplication.preferences.setString("num", counter.toString())
            counterNum.text = counter.toString()

            if (counter <= 10 && counter > 0) {
                cups[counter - 1].setImageResource(R.drawable.cup_filled)
            }
        }

        minusButton.setOnClickListener {
            println("minus")
            counter--
            if (counter < 0) counter = 0

            MyApplication.preferences.setString("num", counter.toString())
            counterNum.text = counter.toString()

            if (counter < 10) {
                cups[counter].setImageResource(R.drawable.cup_empty)
            }
        }

         */


    }

    override fun onResume() {
        super.onResume()
        var counter : Int = 0

        val cup1 = findViewById<ImageView>(R.id.cup1)
        val cup2 = findViewById<ImageView>(R.id.cup2)
        val cup3 = findViewById<ImageView>(R.id.cup3)
        val cup4 = findViewById<ImageView>(R.id.cup4)
        val cup5 = findViewById<ImageView>(R.id.cup5)
        val cup6 = findViewById<ImageView>(R.id.cup6)
        val cup7 = findViewById<ImageView>(R.id.cup7)
        val cup8 = findViewById<ImageView>(R.id.cup8)
        val cup9 = findViewById<ImageView>(R.id.cup9)
        val cup10 = findViewById<ImageView>(R.id.cup10)


        val counterNum = findViewById<TextView>(R.id.numCups)
        counter = MyApplication.preferences.getString("num", "0").toInt()
        counterNum.text = counter.toString()

        val cups = listOf(cup1, cup2, cup3, cup4, cup5, cup6, cup7, cup8, cup9, cup10)

        // Reset all cups to empty
        cups.forEach { it.setImageResource(R.drawable.cup_empty) }

        // Now set the cups to filled based on the counter value
        for (i in 0 until counter) {
            if (i < cups.size) {
                cups[i].setImageResource(R.drawable.cup_filled)
            }
        }
    }
}