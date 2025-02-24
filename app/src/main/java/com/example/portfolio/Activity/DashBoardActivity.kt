package com.example.portfolio.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.example.portfolio.Adapter.OnGoingAdapter
import com.example.portfolio.R
import com.example.portfolio.ViewModel.MainViewModel
import com.example.portfolio.databinding.ActivityMainBinding

class DashBoardActivity : AppCompatActivity() {
    private val mainViewModel:MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val onGoingAdapter = OnGoingAdapter(mainViewModel.loadData())

        binding.viewOnGoing.adapter = onGoingAdapter
        binding.viewOnGoing.layoutManager = GridLayoutManager(this@DashBoardActivity, 2)

    }

    fun clickProfile(view: View) {
        val intent = Intent (view.context, ProfileActivity::class.java)
        startActivity(intent)
    }
}