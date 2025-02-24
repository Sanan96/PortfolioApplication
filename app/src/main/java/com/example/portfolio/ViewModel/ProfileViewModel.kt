package com.example.portfolio.ViewModel

import androidx.lifecycle.ViewModel
import com.example.portfolio.Repository.ProfileRepository

class ProfileViewModel (val repository:ProfileRepository) : ViewModel() {

    constructor(): this(ProfileRepository())

    fun loadDataMyTeam() = repository.myTeamItems
    fun loadDataArchieve () = repository.archiveItems
}