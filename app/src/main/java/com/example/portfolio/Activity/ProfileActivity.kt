package com.example.portfolio.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.portfolio.Adapter.ArchiveAdapter
import com.example.portfolio.Adapter.MyTeamAdapter
import com.example.portfolio.R
import com.example.portfolio.ViewModel.ProfileViewModel
import com.example.portfolio.databinding.ActivityMainBinding
import com.example.portfolio.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    val profileViewModel:ProfileViewModel by viewModels()

    private lateinit var binding:ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myTeamAdapter = MyTeamAdapter (profileViewModel.loadDataMyTeam())
        binding.viewTeamRecView.adapter = myTeamAdapter
        binding.viewTeamRecView.layoutManager = GridLayoutManager (this@ProfileActivity,
            LinearLayoutManager.VERTICAL)


        val archiveAdapter = ArchiveAdapter (profileViewModel.loadDataArchieve())
        binding.viewArchiveRecView.adapter = archiveAdapter
        binding.viewArchiveRecView.layoutManager = GridLayoutManager (this@ProfileActivity, 1,
            LinearLayoutManager.HORIZONTAL, false)
    }

    fun arrowBack(view: View) {
        val intent = Intent (view.context, DashBoardActivity::class.java)
        startActivity(intent)
    }

}