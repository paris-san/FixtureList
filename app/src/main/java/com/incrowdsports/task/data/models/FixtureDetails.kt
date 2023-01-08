package com.incrowdsports.task.data.models

data class FixtureDetails(

    val id: String,
    val feedMatchId: Long = 0,
    val skyId: Long = 0,
    val competition: String,
    val competitionId: Long = 0,
    val status: String,
    val period: String,
    val seasonId: Long = 0,
    val season: String,
    val round: Long = 0,
    val type: String,
    val minute: Long = 0,
    val attendance: Long = 0,
    val homeTeam: HomeTeam,
    val awayTeam: AwayTeam,
    val venue: Venue
)

data class HomeTeam(
    val id: String,
    val skyId: Long = 0,
    val name: String,
    val shortName: String,
    val abbreviation: String,
    val score: String,
    val halfTimeScore: Long = 0,
    val imageUrl: String,
    val players: ArrayList<Player>
)

data class AwayTeam(
    val id: String,
    val skyId: Long = 0,
    val name: String,
    val shortName: String,
    val abbreviation: String,
    val score: String,
    val halfTimeScore: Long = 0,
    val imageUrl: String,
    val players: ArrayList<Player>
)

data class Player(
    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    val known: String,
    val position: String,
    val shirtNumber: Int = 0,
    val status: String,
    val captain: Boolean = false,
    val imageUrl: String,
    val playerImageUrl: String
)

