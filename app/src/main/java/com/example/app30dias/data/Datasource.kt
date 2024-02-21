package com.example.app30dias.data

import com.example.app30dias.R
import com.example.app30dias.model.Game

class GamesRepository{
    companion object {
    val games = listOf(
        Game(
            diaRes = 1,
            nameRes = R.string.game1,
            descriptionRes = R.string.description1,
            imageRes = R.drawable.thelastofus,
            gameImage = R.drawable.thelastoffastgameplay,
            rating = 5.00f
        ),
        Game(
            diaRes = 2,
            nameRes = R.string.game2,
            descriptionRes = R.string.description2,
            imageRes = R.drawable.battlefield,
            gameImage = R.drawable.battlefield1gameplay,
            rating = 4.50f
        ),
        Game(
            diaRes = 3,
            nameRes = R.string.game3,
            descriptionRes = R.string.description3,
            imageRes = R.drawable.residentevil,
            gameImage = R.drawable.residetevil4remakegameplay,
            rating = 4.70f
        ),
        Game(
            diaRes = 4,
            nameRes = R.string.game4,
            descriptionRes = R.string.description4,
            imageRes = R.drawable.monsterhunter,
            gameImage = R.drawable.monsterhunterworldgameplay,
            rating = 4.30f
        ),
        Game(
            diaRes = 5,
            nameRes = R.string.game5,
            descriptionRes = R.string.description5,
            imageRes = R.drawable.elderring,
            gameImage = R.drawable.elderringgameplay,
            rating = 4.50f
        ),
        Game(
            diaRes = 6,
            nameRes = R.string.game6,
            descriptionRes = R.string.description6,
            imageRes = R.drawable.leagueoflegends,
            gameImage = R.drawable.leagueoflegendsgameplay,
            rating = 4.00f
        ),
        Game(
            diaRes = 7,
            nameRes = R.string.game7,
            descriptionRes = R.string.description7,
            imageRes = R.drawable.newworld,
            gameImage = R.drawable.newworldgameplay,
            rating = 4.10f
        ),
        Game(
            diaRes = 8,
            nameRes = R.string.game8,
            descriptionRes = R.string.description8,
            imageRes = R.drawable.stoneshard,
            gameImage = R.drawable.stoneshardgameplay,
            rating = 3.50f
        ),
        Game(
            diaRes = 9,
            nameRes = R.string.game9,
            descriptionRes = R.string.description9,
            imageRes = R.drawable.undertale,
            gameImage = R.drawable.undertalegemaplay,
            rating = 4.80f
        ),
        Game(
            diaRes = 10,
            nameRes = R.string.game10,
            descriptionRes = R.string.description10,
            imageRes = R.drawable.metalslug,
            gameImage = R.drawable.metalsluggameplay,
            rating = 5.00f
        ),
    )
    }
}