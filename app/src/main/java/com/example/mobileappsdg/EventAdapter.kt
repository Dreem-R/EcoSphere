package com.example.mobileappsdg

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(private val events: List<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.eventImage)
        val title: TextView = view.findViewById(R.id.eventTitle)
        val time: TextView = view.findViewById(R.id.eventTime)
        val location: TextView = view.findViewById(R.id.eventLocation)
        val commentCount: TextView = view.findViewById(R.id.commentCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.image.setImageResource(event.imageResId)
        holder.title.text = event.title
        holder.time.text = event.time
        holder.location.text = event.location
        holder.commentCount.text = event.comments.toString()
    }

    override fun getItemCount() = events.size
}
