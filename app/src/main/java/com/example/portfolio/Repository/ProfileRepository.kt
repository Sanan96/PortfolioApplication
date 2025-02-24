package com.example.portfolio.Repository

import com.example.portfolio.Domain.TeamDomain

class ProfileRepository {
    val myTeamItems:MutableList<TeamDomain> = mutableListOf(
        TeamDomain ("Food AppApplication", "Project in Progress"),
        TeamDomain ("AI Python", "Completed"),
        TeamDomain ("Weather Application", "Project in Progress"),
        TeamDomain ("Fitness App", "Completed"),
        TeamDomain ("Quiz App", "Completed"),
        TeamDomain ("Geography Application", "Completed")
    )

    val archiveItems:MutableList<String> = mutableListOf(
        "UI/UX ScreenShot",
        "Kotlin Source Code",
        "Source Codes",
        "Chat GPT",
        "GitHub Codes"
    )
}