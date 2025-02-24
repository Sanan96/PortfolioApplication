package com.example.portfolio.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.portfolio.R
import com.example.portfolio.databinding.ActivityEmptyBinding

class EmptyActiv : AppCompatActivity() {
   private lateinit var binding : ActivityEmptyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmptyBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun arrowback(view: View) {

        binding.arrow.setOnClickListener{
            val intent = Intent (view.context, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}