package com.example.mobileappsdg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CommunityClubFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var eventAdapter: EventAdapter
    private val eventList = listOf(
        Event("Tree Plantation Drive", "Today", "07:00 - 10:00", "Lodhi Garden, New Delhi", R.drawable.tree_drive, 20),
        Event("E-Waste Collection Camp", "Sun, 3 Mar", "09:00 - 16:00", "MG Road, Bengaluru", R.drawable.ewaste, 15),
        Event("Clean Ganga Initiative", "Sat, 9 Mar", "06:30 - 12:00", "Assi Ghat, Varanasi", R.drawable.clean_ganga, 30),
        Event("Himalayan Trek for Conservation", "Fri, 15 Mar", "05:00 - 17:00", "Triund, Himachal Pradesh", R.drawable.trek, 12),
        Event("Community Organic Farming", "Sun, 24 Mar", "08:00 - 12:00", "Pune, Maharashtra", R.drawable.farming, 10),
        Event("Cyclothon for Green Energy", "Sun, 31 Mar", "06:00 - 09:00", "India Gate, New Delhi", R.drawable.cycle, 18)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_community_club, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewEvents)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        eventAdapter = EventAdapter(eventList)
        recyclerView.adapter = eventAdapter
    }
}
