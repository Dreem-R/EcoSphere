package com.example.mobileappsdg

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileappsdg.databinding.ActivityCommunityClubBinding

class CommunityClubActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var eventAdapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_club)

        recyclerView = findViewById(R.id.recyclerViewEvents)
        recyclerView.layoutManager = LinearLayoutManager(this)

        /*
        val events = listOf(
            Event("Tree Plantation Drive", "Today", "07:00 - 10:00", "Lodhi Garden, New Delhi", R.drawable.tree_drive, 20),
            Event("E-Waste Collection Camp", "Sun, 3 Mar", "09:00 - 16:00", "MG Road, Bengaluru", R.drawable.ewaste, 15),
            Event("Clean Ganga Initiative", "Sat, 9 Mar", "06:30 - 12:00", "Assi Ghat, Varanasi", R.drawable.clean_ganga, 30),
            Event("Himalayan Trek for Conservation", "Fri, 15 Mar", "05:00 - 17:00", "Triund, Himachal Pradesh", R.drawable.trek, 12),
            Event("Community Organic Farming", "Sun, 24 Mar", "08:00 - 12:00", "Pune, Maharashtra", R.drawable.farming, 10),
            Event("Cyclothon for Green Energy", "Sun, 31 Mar", "06:00 - 09:00", "India Gate, New Delhi", R.drawable.cycle, 18)
        )


        eventAdapter = EventAdapter(events)
        recyclerView.adapter = eventAdapter
        */
    }
}