package com.bada.widgetprac

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WaterIntakeAdapter(private val intakeList: List<WaterIntakeRecord>) : RecyclerView.Adapter<WaterIntakeAdapter.WaterIntakeViewHolder>() {

    // ViewHolder class
    class WaterIntakeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateText: TextView = itemView.findViewById(R.id.dateTextView)
        val cupsText: TextView = itemView.findViewById(R.id.cupsTextView)
        val tumsText: TextView = itemView.findViewById(R.id.tumsTextView)
        val botsText: TextView = itemView.findViewById(R.id.botsTextView)

    }

    // Inflate the item layout and create the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaterIntakeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_layout, parent, false)
        return WaterIntakeViewHolder(view)
    }

    // Bind the data to the ViewHolder
    override fun onBindViewHolder(holder: WaterIntakeViewHolder, position: Int) {
        val record = intakeList[position]
        holder.dateText.text = record.date
        holder.cupsText.text = record.cups.toString()
        holder.tumsText.text = record.tums.toString()
        holder.botsText.text = record.bots.toString()

    }

    // Return the size of the data list
    override fun getItemCount() = intakeList.size
}