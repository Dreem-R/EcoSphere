package com.example.mobileappsdg

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(
    private val eventList: List<Event>,
    private val onItemClick: (Event) -> Unit
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.eventName.text = event.time
        holder.eventDate.text = event.date
        holder.eventLocation.text = event.location
        holder.eventImage.setImageResource(event.imageResId)

        holder.itemView.setOnClickListener {
            onItemClick(event)
        }
    }

    override fun getItemCount(): Int = eventList.size

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventImage: ImageView = itemView.findViewById(R.id.eventImage)
        val eventName: TextView = itemView.findViewById(R.id.eventTitle)
        val eventDate: TextView = itemView.findViewById(R.id.eventTime)
        val eventLocation: TextView = itemView.findViewById(R.id.eventLocation)
    }
}


