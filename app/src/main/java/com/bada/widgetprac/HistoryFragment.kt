package com.bada.widgetprac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Calendar


/**
 * A simple [Fragment] subclass.
 * Use the [HistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        recyclerView = view.findViewById(R.id.history_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val calendar = Calendar.getInstance()

        val intakeHistoryList = mutableListOf<WaterIntakeRecord>()

        for (i in 0..6) {
            val date = calendar.time
            val cups = MyApplication.preferences.getStringCups(date).toInt()
            val tums = MyApplication.preferences.getStringTums(date).toInt()
            val bots = MyApplication.preferences.getStringBots(date).toInt()

            intakeHistoryList.add(WaterIntakeRecord(SimpleDateFormat("yyyy-MM-dd").format(date), cups, tums, bots))

            calendar.add(Calendar.DAY_OF_YEAR, -1) // Go to the previous day
        }

        intakeHistoryList.reverse() // As we started from the current date and went backward, reverse it to get in chronological order


        recyclerView.adapter = WaterIntakeAdapter(intakeHistoryList)
        return view
        return inflater.inflate(R.layout.fragment_history, container, false)
    }
}