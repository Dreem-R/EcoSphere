package com.example.mobileappsdg

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class EventDetailFragment : Fragment() {

    private lateinit var event: Event

    companion object {
        private const val ARG_EVENT = "event"

        fun newInstance(event: Event): EventDetailFragment {
            val fragment = EventDetailFragment()
            val args = Bundle().apply {
                putParcelable(ARG_EVENT, event)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_event_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        event = arguments?.getParcelable(ARG_EVENT) ?: return

        val eventImageDetail: ImageView = view.findViewById(R.id.eventImageDetail)
        val eventTitleDetail: TextView = view.findViewById(R.id.eventTitleDetail)
        val eventTimeDetail: TextView = view.findViewById(R.id.eventTimeDetail)
        val eventLocationDetail: TextView = view.findViewById(R.id.eventLocationDetail)
        val eventDescription: TextView = view.findViewById(R.id.eventDescription)
        val partici: TextView = view.findViewById(R.id.partici)
        val participateButton: Button = view.findViewById(R.id.participateButton)

        // Set data to views
        eventImageDetail.setImageResource(event.imageResId)
        eventTitleDetail.text = event.title
        eventTimeDetail.text = event.time
        eventLocationDetail.text = event.location
        eventDescription.text = event.description
        partici.text = "Participants: ${event.participants}"

        participateButton.setOnClickListener {
            Toast.makeText(requireContext(), "You have joined ${event.title}!", Toast.LENGTH_SHORT).show()
        }
    }
}



