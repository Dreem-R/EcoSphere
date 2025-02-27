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
                Event(
                    "Tree Plantation Drive", "Today", "07:00 - 10:00", "Lodhi Garden, New Delhi",
                    R.drawable.tree_drive, 20, "Join us for a tree plantation drive to make Delhi greener!"
                ),
                Event(
                    "E-Waste Collection Camp", "Sun, 3 Mar", "09:00 - 16:00", "MG Road, Bengaluru",
                    R.drawable.ewaste, 15, "Dispose of your old electronics responsibly and contribute to a cleaner environment!"
                ),
                Event(
                    "Clean Ganga Initiative", "Sat, 9 Mar", "06:30 - 12:00", "Assi Ghat, Varanasi",
                    R.drawable.clean_ganga, 30, "Join us in cleaning up the sacred Ganges and promoting water conservation!"
                ),
                Event(
                    "Himalayan Trek for Conservation", "Fri, 15 Mar", "05:00 - 17:00", "Triund, Himachal Pradesh",
                    R.drawable.trek, 12, "Explore the breathtaking Himalayan trails while contributing to environmental conservation efforts!"
                ),
                Event(
                    "Community Organic Farming", "Sun, 24 Mar", "08:00 - 12:00", "Pune, Maharashtra",
                    R.drawable.farming, 10, "Learn the art of organic farming and sustainable agriculture at our hands-on workshop!"
                ),
                Event(
                    "Cyclothon for Green Energy", "Sun, 31 Mar", "06:00 - 09:00", "India Gate, New Delhi",
                    R.drawable.cycle, 18, "Enjoy an early morning cycling ride while promoting eco-friendly commuting and green energy!"
                )
            )


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
                val view = inflater.inflate(R.layout.fragment_community_club, container, false)

                recyclerView = view.findViewById(R.id.recyclerViewEvents)
                recyclerView.layoutManager = LinearLayoutManager(requireContext())

                eventAdapter = EventAdapter(eventList) { event ->
                    val fragment = EventDetailFragment.newInstance(event)
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .addToBackStack(null)
                        .commit()
                }


                recyclerView.adapter = eventAdapter

                return view
            }
        }

