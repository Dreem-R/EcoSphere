package com.example.mobileappsdg

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.io.File

class ProfileActivity : AppCompatActivity() {

    private lateinit var profileImageView: ImageView
    private lateinit var userNameEditText: EditText
    private lateinit var emailEditText: EditText

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile1)

        profileImageView = findViewById(R.id.profileImageView)
        userNameEditText = findViewById(R.id.userNameEditText)
        emailEditText = findViewById(R.id.emailEditText)

        val saveButton: Button = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            saveProfileData()
        }

        // Set a listener to choose a profile picture
        val chooseProfilePicButton: Button = findViewById(R.id.chooseProfilePicButton)
        chooseProfilePicButton.setOnClickListener {
            Toast.makeText(this, "Currently unavailable", Toast.LENGTH_SHORT).show()
        }
    }

    // Function to save profile data to SharedPreferences
    private fun saveProfileData() {
        val sharedPreferences = getSharedPreferences("ProfilePrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("userName", userNameEditText.text.toString())
        editor.putString("userEmail", emailEditText.text.toString())

        val imageUri = profileImageView.tag as? String
        editor.putString("profileImageUri", imageUri)

        editor.apply()

        Toast.makeText(this, "Profile saved!", Toast.LENGTH_SHORT).show()
    }

}