package com.example.portfolio.ViewModel

import androidx.lifecycle.ViewModel
import com.example.portfolio.Repository.MainRepository

class MainViewModel (val repository: MainRepository):ViewModel () {
    constructor(): this (MainRepository())

    fun loadData () = repository.items
}