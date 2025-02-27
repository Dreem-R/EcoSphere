package com.example.mobileappsdg

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class Community : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_community)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CommunityClubFragment())
                .commit()
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Inflate Challenges fragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, CommunityClubFragment())
                        .commit()
                    true
                }
                R.id.nav_achievements -> {
                    // Inflate Achievement fragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, Achievement())
                        .commit()
                    true
                }
                R.id.nav_clubs -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container,HomeFragment()).commit()
                    true
                }
                R.id.nav_adopt -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, DonateFragment()).commit()
                    true
                }
                else -> false
            }
        }
    }
}