package com.bada.widgetprac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var counter : Int = 0

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


        val counterNum = view.findViewById<TextView>(R.id.numCups)
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}