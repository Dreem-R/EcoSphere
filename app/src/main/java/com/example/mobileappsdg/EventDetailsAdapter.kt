package com.example.mobileappsdg

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class EventDetailAdapter(private val eventList: List<Event>) :
    RecyclerView.Adapter<EventDetailAdapter.EventDetailViewHolder>() {

    inner class EventDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val eventImageDetail: ImageView = view.findViewById(R.id.eventImageDetail)
        val eventTitleDetail: TextView = view.findViewById(R.id.eventTitleDetail)
        val eventTimeDetail: TextView = view.findViewById(R.id.eventTimeDetail)
        val eventLocationDetail: TextView = view.findViewById(R.id.eventLocationDetail)
        val eventDescription: TextView = view.findViewById(R.id.eventDescription)
        val partici: TextView = view.findViewById(R.id.partici)
        val participateButton: Button = view.findViewById(R.id.participateButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventDetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_event_detail, parent, false)
        return EventDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventDetailViewHolder, position: Int) {
        val event = eventList[position]

        holder.eventImageDetail.setImageResource(event.imageResId)
        holder.eventTitleDetail.text = event.title
        holder.eventTimeDetail.text = event.time
        holder.eventLocationDetail.text = event.location
        holder.eventDescription.text = event.description
        holder.partici.text = "Participants: ${event.participants}"

        holder.participateButton.setOnClickListener {
            Toast.makeText(holder.itemView.context, "You have joined ${event.title}!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = eventList.size
}

