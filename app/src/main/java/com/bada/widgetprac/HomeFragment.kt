package com.bada.widgetprac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.util.Date

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var counterCups : Int = 0
        var counterTums : Int = 0
        var counterBots : Int = 0

        val cup1 = view.findViewById<ImageView>(R.id.cup1)
        val cup2 = view.findViewById<ImageView>(R.id.cup2)
        val cup3 = view.findViewById<ImageView>(R.id.cup3)
        val cup4 = view.findViewById<ImageView>(R.id.cup4)
        val cup5 = view.findViewById<ImageView>(R.id.cup5)
        val cup6 = view.findViewById<ImageView>(R.id.cup6)
        val cup7 = view.findViewById<ImageView>(R.id.cup7)
        val cup8 = view.findViewById<ImageView>(R.id.cup8)
        val cup9 = view.findViewById<ImageView>(R.id.cup9)
        val cup10 = view.findViewById<ImageView>(R.id.cup10)

        val tum1 = view.findViewById<ImageView>(R.id.tum1)
        val tum2 = view.findViewById<ImageView>(R.id.tum2)
        val tum3 = view.findViewById<ImageView>(R.id.tum3)
        val tum4 = view.findViewById<ImageView>(R.id.tum4)

        val bot1 = view.findViewById<ImageView>(R.id.bot1)
        val bot2 = view.findViewById<ImageView>(R.id.bot2)
        val bot3 = view.findViewById<ImageView>(R.id.bot3)

        counterCups = MyApplication.preferences.getStringCups(Date(), "0").toInt()
        var counterStringCups = counterCups.toString()

        counterTums = MyApplication.preferences.getStringTums(Date(), "0").toInt()
        var counterStringTums = counterTums.toString()

        counterBots = MyApplication.preferences.getStringBots(Date(), "0").toInt()
        var counterStringBots = counterBots.toString()


        val cups = listOf(cup1, cup2, cup3, cup4, cup5, cup6, cup7, cup8, cup9, cup10)
        val tums = listOf(tum1, tum2, tum3, tum4)
        val bots = listOf(bot1, bot2, bot3)

        // Reset all cups, tumblers, and bottles to empty
        cups.forEach { it.setImageResource(R.drawable.cup_empty) }
        tums.forEach { it.setImageResource(R.drawable.tumbler_empty) }
        bots.forEach { it.setImageResource(R.drawable.bottle_empty) }

        // Set the cups to filled based on the counter value
        for (i in 0 until counterCups) {
            cups[i].setImageResource(R.drawable.cup_filled)
        }
        for (i in 0 until counterTums) {
            tums[i].setImageResource(R.drawable.tumbler_filled)
        }
        for (i in 0 until counterBots) {
            bots[i].setImageResource(R.drawable.bottle_filled)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}