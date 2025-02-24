package com.example.portfolio.Repository

import com.example.portfolio.Domain.OngoingDomain

class MainRepository {
    val items = listOf(
        OngoingDomain("FoodApp", "June 12, 2025", 50, "ongoing1"),
        OngoingDomain("AI Recording", "June 26, 2025", 45, "ongoing2"),
        OngoingDomain("WeatherApp", "Jule 14, 2025", 85, "ongoing3"),
        OngoingDomain("E-Book App", "June 22, 2025", 65, "ongoing4")
    )
}