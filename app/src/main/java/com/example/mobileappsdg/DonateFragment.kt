package com.example.mobileappsdg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class DonateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_donate, container, false)

        val imageDonation = view.findViewById<ImageView>(R.id.image_donation)
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        val tvOrganization = view.findViewById<TextView>(R.id.tv_organization)
        val tvDescription = view.findViewById<TextView>(R.id.tv_description)
        val tvDonationCount = view.findViewById<TextView>(R.id.tv_donation_count)
        val tvTotalDonation = view.findViewById<TextView>(R.id.tv_total_donation)
        val btnDonate = view.findViewById<Button>(R.id.btn_donate)

        btnDonate.setOnClickListener {
            Toast.makeText(requireContext(), "Redirecting to payment gateway...", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
