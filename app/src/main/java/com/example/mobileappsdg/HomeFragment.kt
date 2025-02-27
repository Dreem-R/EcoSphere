package com.example.mobileappsdg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var communitiesAdapter: CommunitiesAdapter
    private lateinit var feedAdapter: FeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Set up Communities RecyclerView
        val communitiesRecyclerView = view.findViewById<RecyclerView>(R.id.communities_recycler_view)
        communitiesRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        communitiesAdapter = CommunitiesAdapter(getCommunities())
        communitiesRecyclerView.adapter = communitiesAdapter

        // Set up Feed RecyclerView
        val feedRecyclerView = view.findViewById<RecyclerView>(R.id.feed_recycler_view)
        feedRecyclerView.layoutManager = LinearLayoutManager(context)
        feedAdapter = FeedAdapter(getFeedPosts())
        feedRecyclerView.adapter = feedAdapter

        // Set up Post Button
        val publishPostButton = view.findViewById<Button>(R.id.publish_post_button)
        val writePostEditText = view.findViewById<EditText>(R.id.write_post)
        publishPostButton.setOnClickListener {
            val postContent = writePostEditText.text.toString()
            if (postContent.isNotEmpty()) {
                addNewPost(postContent)
                writePostEditText.text.clear()
                Toast.makeText(context, "Post published!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please write something to post.", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun getCommunities(): List<String> {
        return listOf("Spirituality", "Art & Craft", "Reiki Healing", "Coming Soon")
    }

    private fun getFeedPosts(): MutableList<String> {
        return mutableListOf(
            "This is my recent post in Reiki Healing.",
            "Learned amazing tips on Art & Craft!",
            "Sharing spiritual growth insights."
        )
    }

    private fun addNewPost(content: String) {
        val currentPosts = feedAdapter.feedPosts
        currentPosts.add(0, content) // Add to the top of the feed
        feedAdapter.notifyItemInserted(0)
    }
}
